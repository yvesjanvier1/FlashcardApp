Flashcard App
A simple yet interactive flashcard app built with Android Studio using Kotlin and XML.

Flashcard Demo

💡 Replace flashcard-demo.gif with your actual GIF filename once uploaded.

✅ Features Implemented
Required Tasks
Create New Project in Android Studio
Used "Empty Activity" template with Kotlin and API 24+.
Add a view for the front side (question)
TextView with match_parent width, 200dp height, 40sp centered text.
Add a view for the back side (answer)
Second TextView positioned identically to the question.
Show answer when card is tapped
Tap question → hide question, show answer.
Push code to GitHub
Project successfully uploaded to a public GitHub repository.
Optional Tasks
Toggle between question and answer
Tap answer → hide answer, show question again.
Style question and answer differently
Question: white text on blue background; Answer: black text on light blue.
Advanced card styling
Rounded corners, colored border, and elevation using custom drawables.
Add multiple choice answers
Three clickable options displayed below the flashcard.
Color feedback on answer selection
Correct → green background; Incorrect → red background.
Toggle button to show/hide answer choices
Eye icon button that switches between ic_eye and ic_eye_off.
🛠️ How to Run
Clone this repository
bash


1
git clone https://github.com/your-username/flashcard-app.git
Open in Android Studio
Build and run on an emulator or physical device
📁 Project Structure Highlights
activity_main.xml – Main layout with flashcard and choices
MainActivity.kt – Toggle logic, answer validation, and visibility control
res/drawable/ – Custom backgrounds and eye icons
flashcard_question_bg.xml
flashcard_answer_bg.xml
ic_eye.xml / ic_eye_off.xml
🎥 Demo
The GIF above demonstrates:

Tapping the flashcard to reveal/hide the answer
Selecting multiple choice answers with color feedback
Toggling answer visibility using the eye icon
✨ Built with ❤️ using Android Studio, Kotlin, and Constraint-free RelativeLayout layout

📌 Submission Notes
All Required Tasks completed ✅
All 6 Optional Tasks completed ✅
GIF included and embedded ✅
Code pushed to GitHub ✅