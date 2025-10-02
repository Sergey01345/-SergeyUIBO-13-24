1.Бинарная куча (Binary Heap)
class MinHeap {
    vector<int> heap;
    void heapifyUp(int index) {
        while (index > 0 && heap[index] < heap[(index-1)/2]) {
            swap(heap[index], heap[(index-1)/2]);
            index = (index-1)/2;
        }
    }
};
2.Хеш-таблицы (Hash Tables)
#include <unordered_map>
std::unordered_map<std::string, //int> map;#std::unordered_map предоставляет типобезопасную реализацию с возможностью кастомных хеш-функций и политик управления памятью.
map["key"] = 42;  // Шаблонная реализация
3. Числа Фибоначчи и алгоритмы
int fibonacci(int n) {
    if (n <= 1) return n;
    int a = 0, b = 1;
    for (int i = 2; i <= n; i++) {
        int temp = a + b;
        a = b;
        b = temp;
    }
    return b;  // O(n) время, O(1) память
}



