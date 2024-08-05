package database;

import java.util.ArrayList;

import model.TacGia;

public class TacGiaDAO implements DAOInterface<TacGia> {
	private ArrayList<TacGia> arrTacGia = new ArrayList<TacGia>();
	
	@Override
	public ArrayList<TacGia> selectAll(){
		return this.arrTacGia;
	}
	
	@Override
	public TacGia selectById(TacGia tg) {
		for (TacGia tacGia : arrTacGia) {
			if(arrTacGia.equals(tg))
				return tacGia;
		}
		return null;
	}
	
	@Override
	public int insert(TacGia tg) {
		if(this.selectById(tg)==null) {
			this.arrTacGia.add(tg);
			return 1;
		}
		return 0;
	}
	
	@Override
	public int insertAll(ArrayList<TacGia> arr) {
		int dem = 0;
		for (TacGia tacGia : arr) {
			dem+=this.insert(tacGia);	//this ở đây đang chỉ arrTacGia => Gọi phương thức insert để thêm đối tượng tacGia hiện tại vào danh sách arrTacGia.
		}	
		return dem;
	}
	
	@Override
	public int delete(TacGia tg) {
		if(this.selectById(tg)!=null) {
			this.arrTacGia.remove(tg);
			return 1;
		}
		return 0;
	}
	
	@Override
	public int deleteAll(ArrayList<TacGia> arr) {
		int dem = 0;
		for(TacGia tacGia: arr) {
			dem+=this.delete(tacGia);
		}
		return dem;
	}
	
	@Override
	public int update(TacGia t) {
		if (this.selectById(t)!=null) {
			this.arrTacGia.remove(t);
			this.arrTacGia.add(t);
			return 1;
		}
		return 0;
	}
}
