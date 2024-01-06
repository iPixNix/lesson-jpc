package ru.ipixnix.lesson_jpc

/** Пользовательский тип элемента Горизонтального списка */
data class ItemRowModel(
    val imageId: Int, // Идендификатор изображения
    val title: String, // Заголовок элемента
    val content: String // Контент элемента
)
