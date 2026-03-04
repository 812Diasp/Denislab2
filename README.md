
# Лабораторная работа №2 — Основы XML-разметки. LinearLayout и GridLayout

**Дисциплина:** Программирование мобильных устройств  
**Студент:** Ткаченко Денис  
**Группа:** ИНС-24-2  
**СКФУ, 2026**

---

## Цель работы

Изучить основы языка разметки XML для описания пользовательского интерфейса Android-приложений. Научиться использовать менеджеры размещения LinearLayout и GridLayout для создания сложных экранов. Освоить основные атрибуты View и создание простых Drawable-ресурсов.

---

## Структура проекта

```
app/src/main/
├── java/com/example/layoutslab/
│   ├── MainActivity.kt         ← главное меню навигации
│   ├── Task2Activity.kt        ← Задание 2: LinearLayout vertical
│   ├── Task3Activity.kt        ← Задание 3: horizontal + rtl
│   ├── Fig5Activity.kt         ← Часть 1: вложенные LinearLayout
│   ├── Fig8Activity.kt         ← Часть 1: цветные блоки
│   ├── GridActivity.kt         ← Задание 4: GridLayout 3×3
│   ├── GridSpanActivity.kt     ← Задание 5: GridLayout columnSpan
│   └── LetterNActivity.kt      ← Вариант 8: буква «Н»
├── res/
│   ├── drawable/
│   │   ├── rectangle.xml       ← красный прямоугольник с углами
│   │   └── circle.xml          ← синий круг (oval shape)
│   └── layout/
│       ├── activity_main.xml
│       ├── activity_task2.xml
│       ├── activity_task3.xml
│       ├── activity_task_fig5.xml
│       ├── activity_task_fig8.xml
│       ├── activity_grid.xml
│       ├── activity_grid_span.xml
│       └── activity_letter_n.xml
└── AndroidManifest.xml
```

Рисунки:
Главный экран <img width="1922" height="1201" alt="изображение" src="https://github.com/user-attachments/assets/38a5396a-9552-4e2d-89f7-be08ce3fe3a2" />
Задание 2 <img width="914" height="1409" alt="изображение" src="https://github.com/user-attachments/assets/8b70e82b-fe5c-4814-8eb4-7614f14fa2f1" />
Задание 3 <img width="867" height="1339" alt="изображение" src="https://github.com/user-attachments/assets/22f49665-5a1c-4862-b2de-879c2914f186" />
Вложенные Layout <img width="2560" height="1600" alt="изображение" src="https://github.com/user-attachments/assets/f1141cc5-3636-4c5f-bafc-9b2a2cf47e0b" />
Цветные полоски <img width="793" height="1310" alt="изображение" src="https://github.com/user-attachments/assets/14f3bad2-5320-4296-a724-71f25f57f176" />
Задание 4 Grid 3x3 <img width="827" height="1380" alt="изображение" src="https://github.com/user-attachments/assets/750cb940-56d8-44bd-ab41-b1b20d371349" />
Задание 5 <img width="745" height="1289" alt="изображение" src="https://github.com/user-attachments/assets/df92562a-10e2-4008-9e4b-98cd83be7574" />
Буква Н <img width="778" height="1355" alt="изображение" src="https://github.com/user-attachments/assets/0978dbdf-1640-4d24-b2ab-228e607588c0" />


---

## Ход работы

### Задание 1 — Подготовка ресурсов

В папке `res/drawable/` созданы два XML-файла фигур:

**rectangle.xml** — красный прямоугольник с закруглёнными углами и обводкой:
```xml
<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android"
    android:shape="rectangle">
    <solid android:color="#FF0000" />
    <corners android:radius="10dp" />
    <stroke android:width="2dp" android:color="#000000" />
</shape>
```

**circle.xml** — синий круг через `shape="oval"`:
```xml
<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android"
    android:shape="oval">
    <solid android:color="#0000FF" />
    <size android:width="100dp" android:height="100dp" />
</shape>
```

---

### Задание 2 — LinearLayout vertical

Вертикальный `LinearLayout` с тремя `ImageView`: прямоугольник, круг, прямоугольник повёрнутый на 45°.

```xml
<LinearLayout
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:gravity="center_horizontal"
    android:padding="16dp">

    <ImageView android:layout_width="100dp" android:layout_height="100dp"
        android:src="@drawable/rectangle" android:layout_marginBottom="24dp" />

    <ImageView android:layout_width="100dp" android:layout_height="100dp"
        android:src="@drawable/circle" android:layout_marginBottom="24dp" />

    <ImageView android:layout_width="100dp" android:layout_height="100dp"
        android:src="@drawable/rectangle" android:rotation="45" />
</LinearLayout>
```

---

### Задание 3 — Ориентация и выравнивание

Горизонтальный `LinearLayout` с `layoutDirection="rtl"` — элементы выстраиваются справа налево. Каждый элемент имеет разный `layout_gravity` (`center_vertical`, `bottom`, `top`).

```xml
<LinearLayout
    android:layout_width="match_parent"
    android:layout_height="120dp"
    android:orientation="horizontal"
    android:layoutDirection="rtl">

    <ImageView android:layout_width="80dp" android:layout_height="80dp"
        android:src="@drawable/rectangle" android:layout_gravity="center_vertical" />

    <ImageView android:layout_width="80dp" android:layout_height="80dp"
        android:src="@drawable/circle" android:layout_gravity="bottom" />

    <ImageView android:layout_width="80dp" android:layout_height="80dp"
        android:src="@drawable/rectangle" android:rotation="45"
        android:layout_gravity="top" />
</LinearLayout>
```

---

### Часть 1 — Рисунок 5: вложенные LinearLayout

Горизонтальный контейнер содержит два вертикальных дочерних `LinearLayout`, каждый с кнопками. Вес (`layout_weight`) равномерно делит пространство между колонками.

```xml
<LinearLayout android:orientation="horizontal" ...>

    <LinearLayout android:layout_width="0dp" android:layout_weight="1"
        android:orientation="vertical">
        <Button android:layout_height="0dp" android:layout_weight="1" android:text="Кнопка 1" />
        <Button android:layout_height="0dp" android:layout_weight="1" android:text="Кнопка 2" />
        <Button android:layout_height="0dp" android:layout_weight="1" android:text="Кнопка 3" />
    </LinearLayout>

    <LinearLayout android:layout_width="0dp" android:layout_weight="1"
        android:orientation="vertical">
        <Button android:layout_height="0dp" android:layout_weight="2" android:text="Большая кнопка" />
        <Button android:layout_height="0dp" android:layout_weight="1" android:text="Кнопка 5" />
    </LinearLayout>

</LinearLayout>
```

---

### Часть 1 — Рисунок 8: разноцветные блоки

Три строки `LinearLayout` с `View`-элементами разных цветов. Вес распределяет ширину и высоту блоков пропорционально.

```xml
<LinearLayout android:orientation="vertical" ...>

    <LinearLayout android:layout_height="0dp" android:layout_weight="1"
        android:orientation="horizontal">
        <View android:layout_weight="1" android:background="#E53935" ... />
        <View android:layout_weight="1" android:background="#43A047" ... />
        <View android:layout_weight="1" android:background="#1E88E5" ... />
        <View android:layout_weight="1" android:background="#FDD835" ... />
    </LinearLayout>

    <LinearLayout android:layout_height="0dp" android:layout_weight="1"
        android:orientation="horizontal">
        <View android:layout_weight="2" android:background="#8E24AA" ... />
        <View android:layout_weight="1" android:background="#F4511E" ... />
    </LinearLayout>

    <LinearLayout android:layout_height="0dp" android:layout_weight="1"
        android:orientation="horizontal">
        <View android:layout_weight="1" android:background="#00ACC1" ... />
        <View android:layout_weight="1" android:background="#FFB300" ... />
        <View android:layout_weight="1" android:background="#6D4C41" ... />
    </LinearLayout>

</LinearLayout>
```

---

### Задание 4 — GridLayout 3×3

Сетка 3×3 из 9 кнопок. `layout_columnWeight` и `layout_rowWeight` равномерно заполняют всё пространство.

```xml
<GridLayout
    android:columnCount="3"
    android:rowCount="3"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <!-- 9 кнопок с текстом 1–9 -->
    <!-- каждая: layout_width="0dp" layout_height="0dp"
                 layout_columnWeight="1" layout_rowWeight="1" -->

</GridLayout>
```

---

### Задание 5 — GridLayout с объединением ячеек

Использование `layout_columnSpan` для объединения нескольких столбцов в одну ячейку.

| Кнопка | columnSpan | Описание |
|--------|-----------|----------|
| Кнопка 1 | 2 | Занимает первые 2 столбца |
| Кнопка 2 | 1 | Третий столбец |
| Кнопка 3 | 3 | Вся строка целиком |

```xml
<Button android:layout_columnSpan="2" android:layout_gravity="fill"
    android:text="Кнопка 1 (2 колонки)" ... />

<Button android:layout_column="2" android:text="Кнопка 2" ... />

<Button android:layout_row="1" android:layout_columnSpan="3"
    android:layout_gravity="fill" android:text="Кнопка 3 (3 колонки)" ... />
```

---

### Вариант 8 — Буква «Н» из кнопок

**Математическая форма буквы Н:** 2 вертикальных столбца кнопок + 1 горизонтальная перемычка посередине.

Реализация через 5 строк `LinearLayout`:

| Строка | Левый | Центр | Правый |
|--------|-------|-------|--------|
| 1 | Кнопка | — | Кнопка |
| 2 | Кнопка | — | Кнопка |
| 3 | Кнопка | **Кнопка** | Кнопка |
| 4 | Кнопка | — | Кнопка |
| 5 | Кнопка | — | Кнопка |

```xml
<LinearLayout android:layout_height="0dp" android:layout_weight="1"
    android:orientation="horizontal">
    <Button android:layout_weight="1" ... />
    <View android:layout_weight="1" />       
    <Button android:layout_weight="1" ... />
</LinearLayout>

<LinearLayout android:layout_height="0dp" android:layout_weight="1"
    android:orientation="horizontal">
    <Button android:layout_weight="1" ... />
    <Button android:layout_weight="1" ... />  
    <Button android:layout_weight="1" ... />
</LinearLayout>
```

---

## Ответы на контрольные вопросы

**1. Что такое XML? Для каких целей он используется в Android-разработке?**  
XML (eXtensible Markup Language) — язык разметки на основе тегов и атрибутов. В Android используется для декларативного описания пользовательского интерфейса: структуры экранов, расположения элементов, их свойств (цвет, размер, текст). XML-файлы хранятся в `res/layout/` и `res/drawable/`.

**2. Что такое тег (элемент) в XML? Из каких частей он состоит?**  
Тег — основная единица XML. Состоит из: открывающего тега `<Button`, атрибутов `android:text="ОК"`, закрывающего тега `/>` (или пары `</Button>`). Теги могут быть вложены друг в друга, образуя дерево элементов.

**3. Какие менеджеры размещения вы знаете?**
- `LinearLayout` — горизонтальное или вертикальное расположение в одну линию
- `GridLayout` — сетка с заданным числом строк и столбцов
- `ConstraintLayout` — гибкое позиционирование через ограничения (constraints)
- `RelativeLayout` — расположение элементов относительно друг друга или родителя
- `FrameLayout` — элементы накладываются слоями друг на друга
- `TableLayout` — табличная структура с явными строками и ячейками

**4. В чём разница между LinearLayout и GridLayout?**  
`LinearLayout` размещает элементы строго в одну линию (горизонтально или вертикально) — удобен для простых последовательных интерфейсов. `GridLayout` размещает элементы в двумерной сетке с поддержкой объединения ячеек — удобен для калькуляторов, таблиц, клавиатур.

**5. Что такое match_parent и wrap_content?**  
`match_parent` — элемент растягивается на весь размер родительского контейнера (например, кнопка на всю ширину экрана). `wrap_content` — элемент принимает минимальный размер, достаточный для отображения содержимого (например, кнопка по размеру текста).

**6. В чём разница между android:gravity и android:layout_gravity?**  
`android:gravity` управляет выравниванием **содержимого внутри** элемента (например, текст кнопки по центру). `android:layout_gravity` управляет выравниванием **самого элемента** внутри родительского контейнера (например, кнопка прижата к низу LinearLayout).

**7. Какие единицы измерения используются в Android?**  
- `px` — физические пиксели экрана, зависят от плотности — не рекомендуется
- `dp` — density-independent pixels, масштабируются по плотности экрана — для размеров View
- `sp` — scale-independent pixels, учитывают также пользовательский масштаб текста — для `textSize`

**8. Как создать фигуру через XML в drawable?**  
Создать файл в `res/drawable/` с тегом `<shape>`. Атрибут `android:shape` задаёт тип (`rectangle`, `oval`, `line`, `ring`). Внутри задаются: `<solid>` — заливка, `<stroke>` — обводка, `<corners>` — скругление углов, `<size>` — размер.

---

## Вывод

В ходе лабораторной работы изучен язык разметки XML для описания интерфейса Android-приложений. Реализованы менеджеры размещения `LinearLayout` (вертикальный, горизонтальный, RTL, вложенный) и `GridLayout` (равномерная сетка, объединение ячеек). Созданы Drawable-ресурсы (прямоугольник и круг через `<shape>`). В рамках варианта 8 реализована буква «Н» из кнопок с использованием вложенных `LinearLayout` и `layout_weight`.
````
