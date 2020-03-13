package co.sistemcobro.dashboarddb.constante;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum DatosAdicionalesEnum {
Nombre(20), Apellido(25),Departamento(22), Ciudad(17), DireccionTipo(19), Direccion(2),
Telefono1(10),Telefono2(11), Telefono3(12), Telefono4(13), Email(4), AutorizacionDatos(21);

	protected static final Map<Integer, DatosAdicionalesEnum> mapByID = new HashMap<>();
	protected static final Map<String, DatosAdicionalesEnum> mapByNAME = new HashMap<>();

static {
	for (DatosAdicionalesEnum s : EnumSet.allOf(DatosAdicionalesEnum.class)) {
		mapByID.put(s.getIndex(), s);
		mapByNAME.put(s.name(), s);
	}
}

private int index;

DatosAdicionalesEnum(int index) {
	this.index = index;
}

public int getIndex() {
	return index;
}

public String getIndexString() {
	return String.valueOf(index);
}

public static DatosAdicionalesEnum get(int id) {
	return mapByID.get(id);
}

public static DatosAdicionalesEnum get(String name) {
	return mapByNAME.get(name);
}
	
}
