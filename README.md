# OIBSIP
# Number Guessing Game

A console-based number guessing game written in Java. The computer picks a random number and you try to guess it, with "Too High!" / "Too Low!" hints after each guess.

## Features

- Random number generated at the start of every round
- Hints after each guess: `Too High!`, `Too Low!` or `Correct!`
- Attempt counter shown on every prompt (e.g. `Attempt 3/7 (5 left)`)
- Maximum attempts limit; running out shows `You Lost!` and reveals the number
- Play Again option (yes/no) after each round
- Score tracking across rounds, e.g. `Round 2 [Medium] - guessed in 5 attempts`
- Input validation (non-numbers and out-of-range guesses are re-prompted)
- Difficulty levels:

| Level  | Range | Attempts |
|--------|-------|----------|
| Easy   | 1-50  | 10       |
| Medium | 1-100 | 7        |
| Hard   | 1-200 | 5        |

## Tech Stack

- Java 25
- `java.util.Random`, `java.util.Scanner`, `java.util.ArrayList`

## How to Run

### Eclipse
1. File -> New -> Java Project, name it `NumberGuessingGame`.
2. Copy `NumberGuessingGame.java` into the project's `src` folder.
3. Click inside the file and press `Ctrl+F11` (Run As -> Java Application).
4. Type your input in the **Console** tab and press Enter.

### Command line
