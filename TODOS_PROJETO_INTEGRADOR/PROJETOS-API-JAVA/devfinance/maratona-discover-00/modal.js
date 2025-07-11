class ExpenseManager {
    constructor() {
        this.expenses = this.loadExpenses();
        this.initializeElements();
        this.bindEvents();
        this.updateDisplay();
        this.setDefaultDate();
    }

    initializeElements() {
        this.modal = document.getElementById('expenseModal');
        this.openModalBtn = document.getElementById('openModal');
        this.closeModalBtn = document.getElementById('closeModal');
        this.cancelBtn = document.getElementById('cancelBtn');
        this.form = document.getElementById('expenseForm');
        this.notification = document.getElementById('notification');
        
        // Form inputs
        this.descriptionInput = document.getElementById('description');
        this.amountInput = document.getElementById('amount');
        this.dateInput = document.getElementById('date');
        
        // Display elements
        this.totalExpensesEl = document.getElementById('totalExpenses');
        this.expenseCountEl = document.getElementById('expenseCount');
        this.expensesListEl = document.getElementById('expensesList');
    }

    bindEvents() {
        this.openModalBtn.addEventListener('click', () => this.openModal());
        this.closeModalBtn.addEventListener('click', () => this.closeModal());
        this.cancelBtn.addEventListener('click', () => this.closeModal());
        this.form.addEventListener('submit', (e) => this.handleSubmit(e));
        
        // Close modal when clicking outside
        this.modal.addEventListener('click', (e) => {
            if (e.target === this.modal) {
                this.closeModal();
            }
        });
        
        // Close modal with ESC key
        document.addEventListener('keydown', (e) => {
            if (e.key === 'Escape' && this.modal.open) {
                this.closeModal();
            }
        });
        
        // Real-time validation
        this.descriptionInput.addEventListener('input', () => this.validateDescription());
        this.amountInput.addEventListener('input', () => this.validateAmount());
        this.dateInput.addEventListener('input', () => this.validateDate());
    }

    setDefaultDate() {
        const today = new Date().toISOString().split('T')[0];
        this.dateInput.value = today;
    }

    openModal() {
        this.modal.showModal();
        this.descriptionInput.focus();
        this.clearErrors();
    }

    closeModal() {
        this.modal.close();
        this.form.reset();
        this.clearErrors();
        this.setDefaultDate();
    }

    validateDescription() {
        const description = this.descriptionInput.value.trim();
        const errorEl = document.getElementById('descriptionError');
        
        if (!description) {
            errorEl.textContent = 'Descrição é obrigatória';
            return false;
        } else if (description.length < 3) {
            errorEl.textContent = 'Descrição deve ter pelo menos 3 caracteres';
            return false;
        } else {
            errorEl.textContent = '';
            return true;
        }
    }

    validateAmount() {
        const amount = parseFloat(this.amountInput.value);
        const errorEl = document.getElementById('amountError');
        
        if (!amount || amount <= 0) {
            errorEl.textContent = 'Valor deve ser maior que zero';
            return false;
        } else {
            errorEl.textContent = '';
            return true;
        }
    }

    validateDate() {
        const date = this.dateInput.value;
        const errorEl = document.getElementById('dateError');
        
        if (!date) {
            errorEl.textContent = 'Data é obrigatória';
            return false;
        } else {
            const selectedDate = new Date(date);
            const today = new Date();
            today.setHours(23, 59, 59, 999); // Set to end of today
            
            if (selectedDate > today) {
                errorEl.textContent = 'Data não pode ser futura';
                return false;
            } else {
                errorEl.textContent = '';
                return true;
            }
        }
    }

    validateForm() {
        const isDescriptionValid = this.validateDescription();
        const isAmountValid = this.validateAmount();
        const isDateValid = this.validateDate();
        
        return isDescriptionValid && isAmountValid && isDateValid;
    }

    clearErrors() {
        document.getElementById('descriptionError').textContent = '';
        document.getElementById('amountError').textContent = '';
        document.getElementById('dateError').textContent = '';
    }

    handleSubmit(e) {
        e.preventDefault();
        
        if (!this.validateForm()) {
            this.showNotification('Por favor, corrija os erros no formulário', 'error');
            return;
        }

        const expense = {
            id: Date.now(),
            description: this.descriptionInput.value.trim(),
            amount: parseFloat(this.amountInput.value),
            date: this.dateInput.value,
            createdAt: new Date().toISOString()
        };

        this.addExpense(expense);
        this.closeModal();
        this.showNotification('Despesa cadastrada com sucesso!', 'success');
    }

    addExpense(expense) {
        this.expenses.push(expense);
        this.saveExpenses();
        this.updateDisplay();
    }

    removeExpense(id) {
        this.expenses = this.expenses.filter(expense => expense.id !== id);
        this.saveExpenses();
        this.updateDisplay();
        this.showNotification('Despesa removida com sucesso!', 'success');
    }

    loadExpenses() {
        try {
            const stored = localStorage.getItem('expenses');
            return stored ? JSON.parse(stored) : [];
        } catch (error) {
            console.error('Erro ao carregar despesas:', error);
            return [];
        }
    }

    saveExpenses() {
        try {
            localStorage.setItem('expenses', JSON.stringify(this.expenses));
        } catch (error) {
            console.error('Erro ao salvar despesas:', error);
            this.showNotification('Erro ao salvar despesa', 'error');
        }
    }

    updateDisplay() {
        this.updateSummary();
        this.updateExpensesList();
    }

    updateSummary() {
        const total = this.expenses.reduce((sum, expense) => sum + expense.amount, 0);
        const count = this.expenses.length;
        
        this.totalExpensesEl.textContent = this.formatCurrency(total);
        this.expenseCountEl.textContent = count;
    }

    updateExpensesList() {
        if (this.expenses.length === 0) {
            this.expensesListEl.innerHTML = '<p class="empty-state">Nenhuma despesa cadastrada ainda.</p>';
            return;
        }

        // Sort expenses by date (newest first)
        const sortedExpenses = [...this.expenses].sort((a, b) => new Date(b.date) - new Date(a.date));
        
        this.expensesListEl.innerHTML = sortedExpenses.map(expense => `
            <div class="expense-item">
                <div class="expense-info">
                    <h4>${this.escapeHtml(expense.description)}</h4>
                    <p>${this.formatDate(expense.date)}</p>
                </div>
                <div class="expense-amount">
                    ${this.formatCurrency(expense.amount)}
                </div>
            </div>
        `).join('');
    }

    formatCurrency(amount) {
        return new Intl.NumberFormat('pt-BR', {
            style: 'currency',
            currency: 'BRL'
        }).format(amount);
    }

    formatDate(dateString) {
        const date = new Date(dateString + 'T00:00:00');
        return new Intl.DateTimeFormat('pt-BR', {
            day: '2-digit',
            month: '2-digit',
            year: 'numeric'
        }).format(date);
    }

    escapeHtml(text) {
        const div = document.createElement('div');
        div.textContent = text;
        return div.innerHTML;
    }

    showNotification(message, type = 'success') {
        this.notification.textContent = message;
        this.notification.className = `notification ${type}`;
        this.notification.classList.add('show');
        
        setTimeout(() => {
            this.notification.classList.remove('show');
        }, 3000);
    }
}

// Initialize the application when DOM is loaded
document.addEventListener('DOMContentLoaded', () => {
    new ExpenseManager();
});