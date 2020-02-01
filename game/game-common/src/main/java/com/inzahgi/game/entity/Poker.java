package com.inzahgi.game.entity;

import com.inzahgi.game.enums.PokerLevel;
import com.inzahgi.game.enums.PokerType;

/**
 * Poke, with {@link PokerLevel} and {@link PokerType}
 * 
 * @author nico
 */
public class Poker{
	
	private PokerLevel level;
	
	private PokerType type;

	public Poker() {
	}

	public Poker(int i){
		if(i == 54){
			this.level = PokerLevel.LEVEL_BIG_KING;
			this.type = PokerType.BLANK;
		}else if(i == 53){
			this.level = PokerLevel.LEVEL_SMALL_KING;
			this.type = PokerType.BLANK;
		}else {
			int k = (i-1) / 13;
			int j = (i - 13*k)% 14 + 2;
			this.level = PokerLevel.getByLevel(j);
			switch (k){
				case 0:this.type = PokerType.SPADE;break;
				case 1:this.type = PokerType.HEART;break;
				case 2:this.type = PokerType.CLUB;break;
				case 3:this.type = PokerType.DIAMOND;break;
				default:
			}

		}
	}
	public Poker(PokerLevel level, PokerType type) {
		this.level = level;
		this.type = type;
	}

	public final PokerLevel getLevel() {
		return level;
	}

	public final void setLevel(PokerLevel level) {
		this.level = level;
	}

	public final PokerType getType() {
		return type;
	}

	public final void setType(PokerType type) {
		this.type = type;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((level == null) ? 0 : level.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Poker other = (Poker) obj;
		if (level != other.level)
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.valueOf(level.getLevel()) + " ";
	}
	
}
