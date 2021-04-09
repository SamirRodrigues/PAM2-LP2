/**
 * 
 * @author leticia
 * Create - add
 * Read - get
 * Update - set
 * Delete - remove
 *
 */

package br.ufrn.imd.lp.pam.dao;

import br.ufrn.imd.lp.pam.domain.Agency;

public class AgencyDao {

	private Database database;

	public AgencyDao() {
		this.database = Database.getInstance();
	}
	
	public void addAgency(Agency agency) {
		this.database.setAgency(agency);
	}
}
