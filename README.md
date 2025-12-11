# OOP Tic Tac Toe Re-Engineering: Decoupling Game Logic

## 💡 Overview
This project, **Part B: OOP Tic Tac Toe**, focuses on practicing the software engineering process by completely redesigning the existing Tic Tac Toe application. The goal is to move away from monolithic code (where game logic was mixed with GUI actions) towards a clean, highly decoupled Object-Oriented structure.

The final design cleanly separates the **Model** (Game Logic and Board State) from the **View** (GUI) and **Controller** (Game Flow). 

## 🎯 Design Improvement Goals
This lab specifically addresses the following engineering deficiencies in the prior implementation:

1.  **Separation of Concerns:** Ensuring game state management (`TicTacToeBoard`) and game flow logic (`TicTacToeGame`) are entirely separate from the user interface (`TicTacToeGUI`).
2.  **Encapsulation:** Moving static, board-related methods into a dedicated `TicTacToeBoard` object.
3.  **Readability:** Defining small, focused classes like `WinChecker` and `TieChecker` to enhance code clarity.

## 🛠️ Key Design Components (Model-View-Controller Abstraction)

The design is built around clear responsibilities:

| Class | Role | Core Responsibility |
| :--- | :--- | :--- |
| **TicTacToeBoard** | **Model/State** | Represent the 3x3 game board and maintain the state of all cells. |
| **TicTacToeGame** | **Controller/Logic** | Manage the overall game flow, handle turns, and validate moves. |
| **TicTacToeGUI** | **View** | Create the GUI, display the board, and handle user clicks (inputs). |
| **TicTacToeButton** | **View/Input** | Represent a single clickable tile and store its row/column position. |
| **Player** | **Model** | Store player details and the symbol (X/O) being used. |
| **WinChecker** | **Helper/Logic** | Encapsulate the complex logic required to check for three-in-a-row. |

## 📐 UML Class Diagram
The complete UML Class Diagram illustrates the crucial relationships, such as the `TicTacToeGame` having an association with the `TicTacToeBoard` and the `TicTacToeGUI` managing a collection of `TicTacToeButton` components. This diagram serves as the blueprint for the robust implementation.
<img width="1710" height="1107" alt="lab7buml" src="https://github.com/user-attachments/assets/e6051f20-a1ac-4224-92bd-2a04fad72d24" />

## 🧪 Implementation Note
The final coding stage will involve implementing these classes and creating **JUnit tests** for the core logic classes (`TicTacToeBoard`, `WinChecker`). This **test-first Agile approach** ensures that the logic works correctly before integrating it with the GUI.
