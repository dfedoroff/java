class SettingsManager {
    constructor() {
        this.theme = localStorage.getItem('theme') || 'light';
        document.body.className = this.theme;
    }

    toggleTheme() {
        this.theme = this.theme === 'light' ? 'dark' : 'light';
        document.body.className = this.theme;
        localStorage.setItem('theme', this.theme);
    }
}

const settingsManager = new SettingsManager();

