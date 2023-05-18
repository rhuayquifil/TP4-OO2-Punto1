package ar.unrn.domain.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ar.unrn.domain.portsout.InfrastructureExceptions;
import ar.unrn.domain.portsout.Observer;

public abstract class Observable {

	private List<Observer> listaSubscriptores;

	public Observable() {
		super();
		this.listaSubscriptores = new ArrayList<Observer>();
	}

	public void subscribir(Observer subscriptor) {
		this.listaSubscriptores.add(subscriptor);
	}

	protected void notificar(HashMap<String, String> listaDatos) throws InfrastructureExceptions {
		for (Observer subscriptor : listaSubscriptores) {
			subscriptor.actualizar(listaDatos);
		}
	}
}
