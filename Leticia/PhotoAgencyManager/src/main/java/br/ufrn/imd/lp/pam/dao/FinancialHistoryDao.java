package br.ufrn.imd.lp.pam.dao;

import br.ufrn.imd.lp.pam.domain.FinancialHistory;

public class FinancialHistoryDao {

	private Database database;

	public FinancialHistoryDao() {
		this.database = Database.getInstance();
	}

	public void addFinancialHistory(FinancialHistory financialHistory) {
		this.database.getAgency().setFinancialHistory(financialHistory);
	}

	public void removeFinancialHistory(FinancialHistory financialHistory) {
		this.database.getAgency().setFinancialHistory(null);
	}
}
