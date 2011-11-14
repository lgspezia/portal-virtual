package br.com.biopids.domain;

public enum TipoImovel {
	
	ProprioQuitado {
		public String toString() {
			return "Pr�prio quitado";
		}
	},
	ProprioFinanciado{
		public String toString() {
			return "Pr�prio financiado";
		}
	},
	Alugado {
		public String toString() {
			return "Alugado";
		}
	},
	Familiar {
		public String toString() {
			return "Familiar";
		}
	},
	Cedido {
		public String toString() {
			return "Cedido";
		}
	}
	
}
