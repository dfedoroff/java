class NotesManager {
    constructor() {
        this.notes = JSON.parse(localStorage.getItem('notes')) || [];
    }

    add(note) {
        if (note && note.length < 500) {  // Ограничение длины заметки
            this.notes.push(note);
            this.save();
            return true;
        }
        return false;
    }

    getAll() {
        return this.notes;
    }

    save() {
        localStorage.setItem('notes', JSON.stringify(this.notes));
    }
}

const notesManager = new NotesManager();

