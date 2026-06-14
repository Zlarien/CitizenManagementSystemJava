# 🏛️ Citizen Management System — Mairie

> A Java desktop application following the MVC pattern, built with Swing, for managing civil registry records of a town hall.

---

## 📋 Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Architecture & Design Choices](#architecture--design-choices)
- [Project Structure](#project-structure)
- [How to Run](#how-to-run)
- [What I Learned](#what-i-learned)
- [French Version](#-version-française)

---

## Overview

This project simulates the civil registry management system of a French *Mairie* (town hall). It was built as a second-year university project at **Université Paris-Saclay** to demonstrate Object-Oriented Programming principles in Java, specifically the **MVC (Model-View-Controller)** design pattern combined with a **Java Swing** graphical interface.

The system allows a town hall agent to:
- Register new citizens
- Record births, marriages and deaths
- Process divorces
- Consult a citizen's civil status in real time
- View the full list of registered citizens

---

## Features

| Feature | Description |
|---|---|
| 👤 Register a citizen | Adds a new `Homme` or `Femme` object with a validated date of birth |
| 👶 Declare a birth | Links a child to its mother (required) and father (optional) |
| 💍 Declare a marriage | Verifies majority and single status before creating a `Mariage` act |
| 📜 Declare a divorce | Finds the active marriage and sets its divorce flag to true |
| 🔍 Check civil status | Displays name, first name and `EtatCivil` enum value for any citizen |
| 📋 List all citizens | Shows all citizens via their `toString()` method |
| ❌ Quit | Cleanly exits the application |

---

## Architecture & Design Choices

This section explains the key technical decisions made during development.

### MVC Pattern

The application is strictly separated into three layers:

```
User clicks a button
       ↓
     VIEW  (JFrame subclasses — displays UI)
       ↓
  CONTROLLER  (ActionListener — reads fields, validates, acts)
       ↓
    MODEL  (Citoyen, Mairie, Mariage... — stores data)
       ↓
  CONTROLLER updates VIEW with result
```

The Model has **no knowledge** of the View. The View has **no knowledge** of the Model. Only the Controller bridges them. This separation makes each layer independently testable and maintainable.

### Two types of controllers

Inspired directly by the professor's methodology, controllers are split into two categories:

- **Navigation controllers** (`MariageP`, `DivorceP`, `SaisieP`...) — Only open a new JFrame, passing the shared `Mairie` object. One line of logic.
- **Action controllers** (`ContMariage`, `ContDivorce`, `ContSaisie`...) — Read form fields, validate data, modify the model, update the display.

This keeps each class focused on a single responsibility.

### Encapsulation with `private` attributes

All model attributes are declared `private` with explicit getters. This choice was intentional:

- Prevents accidental direct modification from outside the class
- Forces access through controlled methods
- Follows the standard OOP encapsulation principle
- Makes the codebase more robust for future extensions

### Custom `DateCivil` class instead of `String` or `LocalDate`

A dedicated class was created with three `int` attributes: `jour`, `mois`, `annee`.

**Why not `String`?** A string like `"1990-13-45"` would be accepted without any validation.

**Why not `LocalDate`?** `LocalDate` is complex and verbose for this use case. `DateCivil` is simpler to construct from three separate form fields and provides exactly the methods needed: `estValide()` (including leap year logic) and `getAnnee()` for age calculation.

The UI reflects this with **three separate fields** (Day / Month / Year) instead of one text field, making it more intuitive for French users.

### `EtatCivil` enum

Rather than using raw `String` values for civil status, an enum was created:

```java
public enum EtatCivil {
    MARIE,
    DIVORCE,
    CELIBATAIRE,
    DECEDE
}
```

**Why?** Strings are error-prone — `"marie"` and `"Marie"` would be treated as different values. An enum is type-safe: the compiler rejects any undeclared value. Comparisons like `c.getEtatCivil() == EtatCivil.MARIE` are clean and reliable.

### Abstract classes and inheritance

`Citoyen` is declared `abstract` because it contains `public abstract String getSexe()`. A generic citizen without a defined gender cannot be instantiated — every person must be either an `Homme` or a `Femme`. This mirrors real-world civil registry logic.

`EvenementCivil` is abstract for the same reason: `Naissance`, `Mariage` and `Deces` share common attributes (`numeroActe`, `dateEvenement`) but each adds its own specific actors.

---

## Project Structure

```
src/
├── model/
│   ├── EtatCivil.java          ← Enum: 4 civil statuses
│   ├── DateCivil.java          ← Custom date class with validation
│   ├── Mairie.java             ← Central hub: stores all citizens & events
│   ├── Citoyen.java            ← Abstract: base person class
│   ├── Homme.java              ← Extends Citoyen
│   ├── Femme.java              ← Extends Citoyen
│   ├── EvenementCivil.java     ← Abstract: base event class
│   ├── Mariage.java            ← Extends EvenementCivil
│   ├── Naissance.java          ← Extends EvenementCivil
│   └── Deces.java              ← Extends EvenementCivil
│
├── vue/
│   ├── VuePrincipale.java      ← Main menu with 7 buttons
│   ├── VueSaisie.java          ← Form: add a citizen
│   ├── VueMariage.java         ← Form: declare a marriage
│   ├── VueDivorce.java         ← Form: declare a divorce
│   ├── VueNaissance.java       ← Form: declare a birth
│   ├── VueEtat.java            ← Lookup: citizen civil status
│   └── VueListe.java           ← Display: all citizens
│
├── controleur/
│   ├── MariageP.java           ← Nav: opens VueMariage
│   ├── DivorceP.java           ← Nav: opens VueDivorce
│   ├── NaissanceP.java         ← Nav: opens VueNaissance
│   ├── SaisieP.java            ← Nav: opens VueSaisie
│   ├── EtatP.java              ← Nav: opens VueEtat
│   ├── ListeP.java             ← Nav: opens VueListe
│   ├── QuitterP.java           ← Nav: System.exit(0)
│   ├── ContMariage.java        ← Action: validates & records marriage
│   ├── ContDivorce.java        ← Action: finds & dissolves marriage
│   ├── ContNaissance.java      ← Action: validates & records birth
│   ├── ContSaisie.java         ← Action: validates & registers citizen
│   └── ContEtat.java           ← Action: looks up and displays civil status
│
└── Main.java                   ← Entry point
```

---

## How to Run

**Requirements:** Java 8 or higher

```bash
# Clone the repository
git clone https://github.com/Zlarien/citizen-management-mairie.git
cd citizen-management-mairie

# Compile
javac -d out src/**/*.java

# Run
java -cp out Main
```

The main window opens with 7 buttons. Two citizens (Denis Dupont and Denise Dupont) are pre-loaded in the model for testing.

---

## What I Learned

- Implementing the **MVC pattern** in a real desktop application
- Designing class hierarchies with **abstract classes** and **inheritance**
- Using **encapsulation** (private attributes + getters) vs. direct public access — and understanding when each is appropriate
- Building **Java Swing** interfaces with `GridLayout` and `BorderLayout`
- Wiring UI events to business logic via **`ActionListener`**
- Creating custom value objects (`DateCivil`) to replace primitive types
- Using **enums** for type-safe state representation

---

## Author

**Ahamada Soilihi Mohamed-Zayim** — L2 Informatique GR3, Université Paris-Saclay

---
---

# 🏛️ Version Française

> Application Java de bureau suivant le patron MVC, construite avec Swing, pour la gestion du registre civil d'une mairie.

---

## Présentation

Ce projet simule le système de gestion de l'état civil d'une mairie française. Il a été développé dans le cadre d'un projet de deuxième année universitaire à l'**Université Paris-Saclay** pour mettre en pratique les principes de la Programmation Orientée Objet en Java, et plus particulièrement le patron de conception **MVC (Modèle-Vue-Contrôleur)** combiné à une interface graphique **Java Swing**.

---

## Fonctionnalités

| Fonctionnalité | Description |
|---|---|
| 👤 Saisir un citoyen | Ajoute un nouvel objet `Homme` ou `Femme` avec date de naissance validée |
| 👶 Déclarer une naissance | Lie un enfant à sa mère (obligatoire) et son père (optionnel) |
| 💍 Déclarer un mariage | Vérifie la majorité et le célibat avant de créer un acte `Mariage` |
| 📜 Déclarer un divorce | Retrouve le mariage actif et bascule son indicateur de divorce à vrai |
| 🔍 État d'une personne | Affiche nom, prénom et valeur de l'enum `EtatCivil` pour un citoyen |
| 📋 Liste des personnes | Affiche tous les citoyens via leur méthode `toString()` |
| ❌ Quitter | Ferme proprement l'application |

---

## Choix d'architecture et justifications

### Patron MVC

L'application est strictement séparée en trois couches. Le Modèle ne connaît pas la Vue. La Vue ne connaît pas le Modèle. Seul le Contrôleur fait le lien entre les deux.

### Deux types de contrôleurs

- **Contrôleurs de navigation** (`MariageP`, `DivorceP`...) — Ouvrent uniquement une nouvelle fenêtre en transmettant l'objet `Mairie` partagé.
- **Contrôleurs d'action** (`ContMariage`, `ContDivorce`...) — Lisent les champs, valident les données, modifient le modèle, mettent à jour l'affichage.

### Encapsulation avec attributs `private`

Tous les attributs du modèle sont déclarés `private` avec des getters explicites. Ce choix respecte le principe d'encapsulation de la POO : on protège les données internes et on contrôle leur accès.

### Classe `DateCivil` personnalisée

Plutôt qu'une `String` (non validable) ou un `LocalDate` (trop complexe pour ce contexte), une classe simple avec trois entiers `jour`, `mois`, `annee` a été créée. Elle inclut `estValide()` avec gestion des années bissextiles, et s'intègre naturellement avec trois champs de saisie séparés dans l'interface.

### Enum `EtatCivil`

Un enum typé évite les erreurs de casse ou de frappe inhérentes aux `String`. La comparaison `c.getEtatCivil() == EtatCivil.MARIE` est sûre à la compilation.

### Classes abstraites et héritage

`Citoyen` est `abstract` car `getSexe()` est une méthode sans corps — Java interdit d'instancier une classe avec une méthode abstraite. Chaque personne est nécessairement un `Homme` ou une `Femme`. `EvenementCivil` suit la même logique pour `Naissance`, `Mariage` et `Deces`.

---

## Auteur

**Ahamada Soilihi Mohamed-Zayim** — L2 Informatique GR3, Université Paris-Saclay
