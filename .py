Работа с массивами(списками) ЯП Python
def print_array(arr, message="Массив:"):
    """Функция для вывода массива"""
    print(f"{message} {arr}")

def find_element(arr, target):
    """Функция для поиска элемента в массиве"""
    try:
        return arr.index(target)
    except ValueError:
        return -1

def array_stats(arr):
    """Функция для вычисления статистики массива"""
    if not arr:
        return None
    
    return {
        'sum': sum(arr),
        'max': max(arr),
        'min': min(arr),
        'average': sum(arr) / len(arr),
        'length': len(arr)
    }

def main():
    print("=== ПРОГРАММА ДЛЯ РАБОТЫ С МАССИВАМИ (СПИСКАМИ) ===")
    print()
    
    # Базовые операции со списком
    print("1. Базовые операции со списком:")
    my_list = [5, 2, 8, 1, 9, 3, 7]
    print_array(my_list, "Исходный список:")
    
    # Добавление элементов
    my_list.append(10)  # в конец
    my_list.insert(0, 0)  # в начало
    print_array(my_list, "После добавления 0 и 10:")
    
    # Сортировка
    sorted_list = sorted(my_list)
    print_array(sorted_list, "Отсортированный список (новая копия):")
    
    # Сортировка исходного списка
    my_list.sort()
    print_array(my_list, "Исходный список после сортировки:")
    
    # Поиск элемента
    search_value = 8
    index = find_element(my_list, search_value)
    if index != -1:
        print(f"Элемент {search_value} найден на позиции {index}")
    else:
        print(f"Элемент {search_value} не найден")
    
    # Статистика
    stats = array_stats(my_list)
    print(f"Сумма элементов: {stats['sum']}")
    print(f"Максимальный элемент: {stats['max']}")
    print(f"Минимальный элемент: {stats['min']}")
    print(f"Среднее значение: {stats['average']:.2f}")
    print(f"Длина массива: {stats['length']}")
    
    print()
    
    # Срезы (slicing)
    print("2. Работа со срезами:")
    print_array(my_list, "Весь список:")
    print(f"Первые 3 элемента: {my_list[:3]}")
    print(f"Последние 3 элемента: {my_list[-3:]}")
    print(f"Элементы с 2 по 5: {my_list[2:6]}")
    print(f"Каждый второй элемент: {my_list[::2]}")
    
    print()
    
    # Списочные выражения (list comprehensions)
    print("3. Списочные выражения:")
    squares = [x**2 for x in my_list]
    print_array(squares, "Квадраты элементов:")
    
    even_numbers = [x for x in my_list if x % 2 == 0]
    print_array(even_numbers, "Четные числа:")
    
    print()
    
    # Копирование списков
    print("4. Копирование списков:")
    list_copy = my_list.copy()  # поверхностная копия
    list_copy[0] = 999
    print_array(my_list, "Оригинальный список:")
    print_array(list_copy, "Измененная копия:")
    
    print()
    
    # Удаление элементов
    print("5. Удаление элементов:")
    remove_value = 5
    if remove_value in my_list:
        my_list.remove(remove_value)
        print_array(my_list, f"После удаления {remove_value}:")
    
    # Удаление по индексу
    if len(my_list) > 0:
        removed_element = my_list.pop(2)
        print_array(my_list, f"После удаления элемента на позиции 2 ({removed_element}):")
    
    # Очистка списка
    temp_list = [1, 2, 3, 4, 5]
    print_array(temp_list, "Временный список до очистки:")
    temp_list.clear()
    print_array(temp_list, "Временный список после очистки:")
    print(f"Список пустой: {len(temp_list) == 0}")

if name == "__main__":
    main()
Реализация связного спика на Python
class Node:
    """Класс для узла связного списка"""
    def __init__(self, data):
        self.data = data
        self.next = None

class LinkedList:
    """Класс для связного списка"""
    
    def __init__(self):
        self.head = None
        self.size = 0
    
    def is_empty(self):
        """Проверка на пустоту"""
        return self.head is None
    
    def append(self, data):
        """Добавление элемента в конец"""
        new_node = Node(data)
        if self.is_empty():
            self.head = new_node
        else:
            current = self.head
            while current.next:
                current = current.next
            current.next = new_node
        self.size += 1
    
    def prepend(self, data):
        """Добавление элемента в начало"""
        new_node = Node(data)
        new_node.next = self.head
        self.head = new_node
        self.size += 1
    
    def insert(self, index, data):
        """Вставка элемента по индексу"""
        if index < 0 or index > self.size:
            raise IndexError("Индекс вне диапазона")
        
        if index == 0:
            self.prepend(data)
            return
        
        new_node = Node(data)
        current = self.head
        for _ in range(index - 1):
            current = current.next
        
        new_node.next = current.next
        current.next = new_node
        self.size += 1
    
    def delete(self, data):
        """Удаление элемента по значению"""
        if self.is_empty():
            return False
        
        if self.head.data == data:
            self.head = self.head.next
            self.size -= 1
            return True
        
        current = self.head
        while current.next:
            if current.next.data == data:
                current.next = current.next.next
                self.size -= 1
                return True
            current = current.next
        
        return False
    
    def search(self, data):
        """Поиск элемента"""
        current = self.head
        index = 0
        while current:
            if current.data == data:
                return index
            current = current.next
            index += 1
        return -1
    
    def get(self, index):
        """Получение элемента по индексу"""
        if index < 0 or index >= self.size:
            raise IndexError("Индекс вне диапазона")
        
        current = self.head
        for _ in range(index):
            current = current.next
        return current.data
    
    def display(self):
        """Вывод списка"""
        if self.is_empty():
            print("Список пуст")
            return
        
        elements = []
        current = self.head
        while current:
            elements.append(str(current.data))
            current = current.next
        
        print(f"Связный список: {' -> '.join(elements)}")
        print(f"Размер: {self.size}")
    
    def reverse(self):
        """Разворот списка"""
        prev = None
        current = self.head
        while current:
            next_node = current.next
            current.next = prev
            prev = current
            current = next_node
        self.head = prev
    
    def to_list(self):
        """Преобразование в обычный список"""
        result = []
        current = self.head
        while current:
            result.append(current.data)
            current = current.next
        return result

def demonstrate_linked_list():
    """Демонстрация работы связного списка"""
    print("=== ПРОГРАММА ДЛЯ РАБОТЫ СО СВЯЗНЫМ СПИСКОМ ===")
    print()
    
    # Создание связного списка
    ll = LinkedList()
    
    print("1. Добавление элементов:")
    ll.append(10)
    ll.append(20)
    ll.append(30)
    ll.prepend(5)
    ll.display()
    
    print()
    print("2. Вставка по индексу:")
    ll.insert(2, 15)
    ll.display()
    
    print()
    print("3. Поиск элементов:")
    search_values = [15, 25, 5]
    for value in search_values:
        index = ll.search(value)
        if index != -1:
            print(f"Элемент {value} найден на позиции {index}")
        else:
            print(f"Элемент {value} не найден")
    
    print()
    print("4. Получение элементов по индексу:")
    for i in range(ll.size):
        print(f"Элемент {i}: {ll.get(i)}")
    
    print()
    print("5. Удаление элементов:")
    ll.delete(15)
    ll.display()
    ll.delete(5)
    ll.display()
    ll.delete(30)
    ll.display()
    
    print()
    print("6. Разворот списка:")
    ll.append(40)
    ll.append(50)
    ll.display()
    ll.reverse()
    ll.display()
    
    print()
    print("7. Преобразование в обычный список:")
    regular_list = ll.to_list()
    print(f"Обычный список: {regular_list}")
    
    print()
    print("8. Проверка на пустоту:")
    print(f"Список пустой: {ll.is_empty()}")
    
    # Создание пустого списка для демонстрации
    empty_ll = LinkedList()
    print(f"Пустой список пустой: {empty_ll.is_empty()}")

if __name__ == "__main__":
    demonstrate_linked_list()