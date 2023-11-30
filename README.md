### QuickSort and deciding which pivot is the best
- This is quicksort, I am using 6 pivot deciding methods from lectures. I am going to name them partition 1-6.
- Goal is to decide which partition is the best for QuickSort.
- Modified QuickSort that uses insertion sort when size of partitions is small enough.
## Usage
- Compile
```bash
javac program10.java
```
- Run 
```bash
java program10 car_sales_data.csv
```
- I didn't have to allocate any extra memory to prevent stack overflow. But if it is needed include -Xss1024m just after "java", in the run command

## Author

Jere Perisic

## Version
November 29, 2023