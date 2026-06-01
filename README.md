# Merge Sort Visualizer in Java

A graphical visualization of the Merge Sort algorithm built using Java Swing. This project demonstrates how Merge Sort works step-by-step by animating the sorting process with colored bars representing array elements.

## Features

* Visual representation of the Merge Sort algorithm
* Real-time sorting animation
* Color-coded operations:

  * Green: Default unsorted elements
  * Orange: Elements being compared
  * Blue: Elements being merged
  * Light Green: Subarrays successfully sorted
  * Purple: Final sorted array
* Random array generation
* Keyboard controls for sorting and resetting
* Smooth animation using Java Threads and Swing

## Technologies Used

* Java
* Java Swing (GUI)
* AWT Graphics
* Multithreading

## How Merge Sort Works

Merge Sort is a Divide and Conquer algorithm that:

1. Divides the array into two halves.
2. Recursively sorts each half.
3. Merges the sorted halves back together.

### Time Complexity

| Case         | Complexity |
| ------------ | ---------- |
| Best Case    | O(n log n) |
| Average Case | O(n log n) |
| Worst Case   | O(n log n) |

### Space Complexity

O(n)

## Controls

| Key   | Action                    |
| ----- | ------------------------- |
| ENTER | Start Merge Sort          |
| R     | Generate New Random Array |

## Project Structure

```text
MergeSortVisualizer.java
│
├── Array Generation
├── GUI Rendering
├── Merge Sort Algorithm
├── Merge Function
├── Animation Handling
└── Keyboard Controls
```

## Screenshots

Add screenshots of the visualizer here.

```markdown
![Merge Sort Visualization](screenshots/merge-sort.png)
```

## Running the Project

### Compile

```bash
javac MergeSortVisualizer.java
```

### Run

```bash
java MergeSortVisualizer
```

## Learning Objectives

This project helps understand:

* Recursion
* Divide and Conquer Algorithms
* Merge Sort Internals
* Java Swing GUI Development
* Graphics Rendering
* Event Handling
* Multithreading in Java

## Future Improvements

* Adjustable sorting speed
* Pause/Resume functionality
* Array size customization
* Sound effects during sorting
* Additional sorting algorithms

  * Bubble Sort
  * Quick Sort
  * Heap Sort
  * Selection Sort
  * Insertion Sort

## Author

Adarsh Kumar Singh

If you found this project useful, consider giving it a ⭐ on GitHub.
