Сравнение работы с массивами/списками в Python, Java и C++
1. Инициализация и объявление
Python:

# Динамический список
arr = [1, 2, 3, 4, 5]
arr.append(6)  # Автоматическое расширение
Java:

// Статический массив
int[] staticArray = {1, 2, 3, 4, 5};
// Динамический список
ArrayList<Integer> dynamicList = new ArrayList<>();
dynamicList.add(1);
C++:

// Статический массив
int staticArray[5] = {1, 2, 3, 4, 5};
// Динамический вектор
std::vector<int> dynamicVector = {1, 2, 3, 4, 5};
dynamicVector.push_back(6);

2. Доступ к элементам
Python (самый простой):

print(arr[0])    # Первый элемент
print(arr[-1])   # Последний элемент (уникально для Python)
Java (без отрицательных индексов):

System.out.println(arr[0]);  // Первый элемент
System.out.println(arr[arr.length - 1]);  // Последний элемент
C++ (максимальный контроль):

std::cout << arr[0] << std::endl;  // Без проверки границ
std::cout << arr.at(0) << std::endl;  // С проверкой границ

3. Итерация по элементам
Python (самый лаконичный):

for item in arr:
    print(item)

for i, item in enumerate(arr):
    print(f"Index {i}: {item}")

Java (несколько вариантов):

// For-each
for (int item : arr) {
    System.out.println(item);
}

// Классический for
for (int i = 0; i < arr.length; i++) {
    System.out.println("Index " + i + ": " + arr[i]);
}

C++ (разные итераторы):

// Range-based for (C++11)
for (auto item : vec) {
    std::cout << item << std::endl;
}

// Использование итераторов
for (auto it = vec.begin(); it != vec.end(); ++it) {
    std::cout << *it << std::endl;
}
4. Динамическое изменение размера
Python (полностью автоматическое):

arr = []           # Пустой список
arr.append(1)      # Добавление в конец
arr.insert(0, 0)   # Вставка в начало
arr.pop()          # Удаление с конца

Java (только для коллекций):
ArrayList<Integer> list = new ArrayList<>();
list.add(1);       // Добавление в конец
list.add(0, 0);    // Вставка в начало
list.remove(0);    // Удаление по индексу

C++ (явное управление):
std::vector<int> vec;
vec.push_back(1);          // Добавление в конец
vec.insert(vec.begin(), 0); // Вставка в начало
vec.pop_back();            // Удаление с конца

5. Память и управление ресурсами
Python:
# Автоматическое управление памятью
arr = [1, 2, 3]
del arr  # Не обязательно, GC сделает всё сам
Java:
// Сборка мусора
int[] arr = new int[1000];
arr = null; // Помечаем для GC
C++:
// Явное управление
int* arr = new int[1000];
// ... использование ...
delete[] arr; // Обязательно!
// Или с умными указателями (рекомендуется)
std::unique_ptr<int[]> smartArr(new int[1000]);
6. Функциональные возможности
Python (самый богатый функционал):

# Срезы
sub = arr[1:4]        # [2, 3, 4]
reverse = arr[::-1]   # [5, 4, 3, 2, 1]

# List comprehensions
squares = [x**2 for x in arr if x % 2 == 0]

Java (требует Stream API):

// Только с Java 8+
List<Integer> squares = arr.stream()
    .filter(x -> x % 2 == 0)
    .map(x -> x * x)
    .collect(Collectors.toList());

C++ (алгоритмы STL):

std::vector<int> squares;
std::copy_if(arr.begin(), arr.end(), std::back_inserter(squares),
    [](int x) { return x % 2 == 0; });
std::transform(squares.begin(), squares.end(), squares.begin(),
    [](int x) { return x * x; });

Выбирайте Java если:

