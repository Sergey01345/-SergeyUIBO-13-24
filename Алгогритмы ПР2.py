1. Бинарная куча (Binary Heap)
import heapq
# Встроенная реализация min-heap
numbers = [5, 2, 8, 1, 9]
heapq.heapify(numbers)  # Преобразует список в кучу за O(n)
min_val = heapq.heappop(numbers)  # Извлекает минимум за O(log n)
2. Хеш-таблицы (Hash Tables)
# Встроенный словарь
hash_table = {}
hash_table["key"] = "value"  # Автоматическое хеширование
value = hash_table.get("key")
3. Числа Фибоначчи и алгоритмы
def fib(n):
    if n <= 1:
        return n
return fib(n-1) + fib(n-2)  # Экспоненциальная сложность