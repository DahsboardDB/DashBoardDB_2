package co.sistemcobro.dashboarddb.constante;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum GrupoTIpificacionEnum {
	GRUPO_COMITE_ACUERDO(10),GRUPO_COMITE(9), GRUPO_NO_EFECTIVO(2), GRUPO_OTROS(3), GRUPO_PROMESA(5), GRUPO_HABLA_CON_TERCERON(
			4), GRUPO_PAGO_NO_APLICA(6), GRUPO_RECLAMO(7);

	protected static final Map<Integer, GrupoTIpificacionEnum> mapByID = new HashMap<>();
	protected static final Map<String, GrupoTIpificacionEnum> mapByNAME = new HashMap<>();

	static {
		for (GrupoTIpificacionEnum s : EnumSet.allOf(GrupoTIpificacionEnum.class)) {
			mapByID.put(s.getIndex(), s);
			mapByNAME.put(s.name(), s);
		}
	}

	private int index;

	GrupoTIpificacionEnum(int index) {
		this.index = index;
	}

	public int getIndex() {
		return index;
	}

	public String getIndexString() {
		return String.valueOf(index);
	}

	public static GrupoTIpificacionEnum get(int id) {
		return mapByID.get(id);
	}

	public static GrupoTIpificacionEnum get(String name) {
		return mapByNAME.get(name);
	}

}
