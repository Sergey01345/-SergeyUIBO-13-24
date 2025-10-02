1.Бинарная куча (Binary Heap)
public class BinaryHeap<T extends Comparable<T>> {
    private ArrayList<T> heap;
    // Использует Comparable для сравнения элементов
}
2.Хеш-таблицы (Hash Tables)
HashMap<String, Integer> map = new HashMap<>();
map.put("key", 42);  // Автоматическое boxing/unboxing
3. Числа Фибоначчи и алгоритмы
public static long fibIterative(int n) {
 // Обрабатываем базовые случаи 
if (n <= 1) {
 return n;
 } 
// Инициализируем два первых числа последовательности 
long a = 0; // F(0) 
long b = 1; // F(1)
 // Цикл от 2 до n включительно for (int i = 2; i <= n; i++) {
 // Вычисляем следующее число как сумму двух предыдущих
 long next = a + b; 
// Сдвигаем переменные: a становится b, b становится next 
a = b; // Теперь a = F(i-1) 
b = next; // Теперь b = F(i) 
} 
// Возвращаем n-е число Фибоначчи 
return b;
 }