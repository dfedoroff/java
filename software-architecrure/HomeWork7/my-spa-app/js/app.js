document.addEventListener('DOMContentLoaded', function() {
    const content = document.getElementById('content');

    function renderNotesPage() {
        content.innerHTML = `
            <h2>Добавить заметку</h2>
            <textarea id="noteInput" rows="4" cols="50"></textarea>
            <button id="addNoteBtn">Добавить</button>
            <div id="error"></div>
            <h2>Ваши заметки</h2>
            <ul id="notesList"></ul>
        `;

        const noteInput = document.getElementById('noteInput');
        const addNoteBtn = document.getElementById('addNoteBtn');
        const notesList = document.getElementById('notesList');
        const errorDiv = document.getElementById('error');

        function displayNotes() {
            notesList.innerHTML = '';
            notesManager.getAll().forEach(note => {
                const listItem = document.createElement('li');
                listItem.textContent = note;
                notesList.appendChild(listItem);
            });
        }

        addNoteBtn.addEventListener('click', function() {
            const noteText = noteInput.value.trim();
            if (notesManager.add(noteText)) {
                noteInput.value = '';
                errorDiv.textContent = '';
                displayNotes();  // Обновляем список заметок после добавления новой
            } else {
                errorDiv.textContent = 'Ошибка: заметка не может быть пустой или превышать 500 символов.';
            }
        });

        displayNotes();  // Отображаем существующие заметки при первоначальной загрузке страницы "Заметки"
    }

    router.register('#home', function() {
        content.innerHTML = '<h1>Добро пожаловать!</h1><p>Это наше удивительное SPA-приложение. Здесь вы можете создавать заметки и просматривать контактную информацию.</p>';
    });

    router.register('#notes', renderNotesPage);

    router.register('#contacts', function() {
        content.innerHTML = '<h1>Контакты</h1><p>Email: example@example.com</p><p>Телефон: +7 (123) 456-78-90</p>';
    });

    router.register('#settings', function() {
        content.innerHTML = `
            <h1>Настройки</h1>
            <button id="toggleThemeBtn">Сменить тему</button>
        `;

        document.getElementById('toggleThemeBtn').addEventListener('click', function() {
            settingsManager.toggleTheme();
        });
    });

    router.register('#404', function() {
        content.innerHTML = '<h1>404: Страница не найдена</h1>';
    });

    // Первоначальная загрузка
    router.navigate(window.location.hash || '#home');

    // Обработчик изменения URL
    window.addEventListener('hashchange', function() {
        router.navigate(window.location.hash);
    });
});

