package com.example.journal_prueba

import java.util.Date

class JournalData(
    var id: Long,            // Identificador único de la entrada
    var content: String,     // Contenido del diario
    var date: Date,          // Fecha de la entrada
    var moodEmoji: String,   // Emoji de estado de ánimo (por ejemplo, ":)")
    var imagePath: String?   // Ruta o referencia a la imagen asociada (puede ser nula)
) {
    constructor(content: String, date: Date, moodEmoji: String, imagePath: String?) : this(0, content, date, moodEmoji, imagePath)
}