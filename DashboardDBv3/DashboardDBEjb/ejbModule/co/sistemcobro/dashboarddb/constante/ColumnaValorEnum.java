package co.sistemcobro.dashboarddb.constante;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum ColumnaValorEnum {
	VALORFACTURAIVA(1), CARTERACORRIENTE(2), CARTERAVENCIDA(3), TOTALCARTERA(4), VALORAPLICADO(5), ANULACIONES(
			6), INTERESESMORA(7), HONORARIOSCOBRADOS(8), TOTALMORAHONORARIOS(9), TOTALOBLIGACIONINTHON(10);

	protected static final Map<Integer, ColumnaValorEnum> mapByID = new HashMap<>();
	protected static  final Map<String, ColumnaValorEnum> mapByNAME = new HashMap<>();

	static {
		for (ColumnaValorEnum s : EnumSet.allOf(ColumnaValorEnum.class)) {
			mapByID.put(s.getIndex(), s);
			mapByNAME.put(s.name(), s);
		}
	}

	private int index;

	ColumnaValorEnum(int index) {
		this.index = index;
	}

	public int getIndex() {
		return index;
	}

	public String getIndexString() {
		return String.valueOf(index);
	}

	public static ColumnaValorEnum get(int id) {
		return mapByID.get(id);
	}

	public static ColumnaValorEnum get(String name) {
		return mapByNAME.get(name);
	}

}
