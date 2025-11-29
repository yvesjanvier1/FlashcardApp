# Application FlashcardApp – Labo 1 et 2

Une application Android entièrement fonctionnelle de type flashcard, développée avec Kotlin et XML, offrant un type interactif, des choix multiples avec retour visuel et un style d’interface personnalisé.

**Flashcard demo 1**
![flashcard-demo](https://github.com/user-attachments/assets/81e0524f-6452-4005-af51-7499d19e3a9b)

**Flashcard demo 2**
![flashcard 2](https://github.com/user-attachments/assets/7f460355-5e94-4095-b507-a19a5a4c0b10)

---

## ✅ Tâches réalisées

### Tâches obligatoires
- [x] **Créer un nouveau projet dans Android Studio**  
  Utilisation du modèle « Empty Activity » avec Kotlin et SDK minimum API 24.
- [x] **Ajouter une vue pour le recto de la carte (question)**  
  `TextView` avec une largeur de `match_parent`, une hauteur de `200dp` et un texte centré en `40sp`.
- [x] **Ajouter une vue pour le verso de la carte (réponse)**  
  Deuxième `TextView` positionné exactement au même endroit que la question.
- [x] **Afficher la réponse lorsque la carte est appuyée**  
  Appuyer sur la question → masquer la question, afficher la réponse.
- [x] **Publier le code sur GitHub**  
  Projet hébergé publiquement sur GitHub.

### Tâches facultatives
- [x] **Basculer entre question et réponse**  
  Appuyer sur la réponse → masquer la réponse, afficher à nouveau la question.
- [x] **Styliser différemment la question et la réponse**  
  Question : texte blanc sur fond bleu ; Réponse : texte bleu sur fond bleu clair.
- [x] **Style avancé de la carte**  
  Coins arrondis, bordure colorée et effet d’élévation à l’aide de ressources `ShapeDrawable` personnalisées.
- [x] **Ajouter des réponses à choix multiples**  
  Trois options sélectionnables affichées sous la carte flash.
- [x] **Retour visuel coloré selon la sélection**  
  Réponse correcte → fond vert avec bordure ; Réponse incorrecte → fond rouge avec bordure (les deux conservent les coins arrondis).
- [x] **Bouton pour afficher/masquer les choix de réponse**  
  Icône en forme d’œil centrée en bas de l’écran, basculant entre `ic_eye` (afficher) et `ic_eye_off` (masquer).

---

## 📱 Fonctionnalités en action

- Appuyez sur la carte pour révéler la réponse  
- Appuyez à nouveau pour revenir à la question  
- Sélectionnez n’importe quelle option à choix multiple pour obtenir un retour visuel immédiat  
- Utilisez l’icône en forme d’œil en bas de l’écran pour masquer ou afficher les choix  
- Arrière-plan blanc propre avec une interface cohérente sur le thème bleu

---

## 🛠️ Structure principale du projet

- **`activity_main.xml`** – Mise en page principale utilisant `RelativeLayout`, incluant la carte et les choix  
- **`MainActivity.kt`** – Gère le basculement de visibilité, la validation des réponses et le retour sur les choix  
- **`res/drawable/`** – Ressources graphiques personnalisées :
  - `flashcard_question_bg.xml`
  - `flashcard_answer_bg.xml`
  - `choice_correct_bg.xml`
  - `choice_incorrect_bg.xml`
  - `ic_eye.xml` / `ic_eye_off.xml`

---

## ▶️ Comment exécuter le projet

1. Clonez le dépôt :
   ```bash
   git clone https://github.com/yvesjanvier1/FlashcardApp.git
