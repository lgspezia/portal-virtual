package br.com.biopids.domain;

public enum Escolaridade {
	
	SuperiorCompleto {
		public String toString() {
			return "Superior Completo";
		}
	},
	SuperiorInconpleto {
		public String toString() {
			return "Superior Incompleto";
		}
	},
	EMCompleto {
		public String toString() {
			return "Ensino M�dio Completo";
		}
	},
	EMIncompleto {
		public String toString() {
			return "Ensino M�dio Incompleto";
		}
	},
	EFCompleto {
		public String toString() {
			return "Ensino Fundamental Completo";
		}
	},
	EFIncompleto {
		public String toString() {
			return "Ensino Fundamental Incompleto";
		}
	}
}
