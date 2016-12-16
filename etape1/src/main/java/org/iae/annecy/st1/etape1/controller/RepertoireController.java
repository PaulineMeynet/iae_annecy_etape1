package org.iae.annecy.st1.etape1.controller;

import org.iae.annecy.st1.etape1.model.client.Repertoire;

public class RepertoireController {
	Repertoire rep;
	
	
	public RepertoireController(Repertoire r1) {
		// TODO Auto-generated constructor stub
		this.rep = r1;
	}

	
	public String get(){
		return rep.afficherRepertoire();
	}

}
