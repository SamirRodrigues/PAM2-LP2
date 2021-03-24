package br.ufrn.imd.lp.pam.domain;

import java.util.HashMap;

public class FinancialHistory {
	
	private HashMap<String, Balance> balances;

	public FinancialHistory() {
		this.balances = new HashMap<String, Balance>();
	}

	protected void addBalance(Balance balance) {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(balance.getYear());
		sb.append("-");
		sb.append(balance.getMonth());
		
		balances.put(sb.toString(), balance);
	}
	
}
