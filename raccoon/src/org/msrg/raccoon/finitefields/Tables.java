package org.msrg.raccoon.finitefields;

public class Tables {

	public static final byte[] LOG = {0,0,25,1,50,2,26,-58,75,-57,27,104,51,-18,-33,3,100,4,-32,14,52,-115,-127,-17,76,113,8,-56,-8,105,28,-63,125,-62,29,-75,-7,-71,39,106,77,-28,-90,114,-102,-55,9,120,101,47,-118,5,33,15,-31,36,18,-16,-126,69,53,-109,-38,-114,-106,-113,-37,-67,54,-48,-50,-108,19,92,-46,-15,64,70,-125,56,102,-35,-3,48,-65,6,-117,98,-77,37,-30,-104,34,-120,-111,16,126,110,72,-61,-93,-74,30,66,58,107,40,84,-6,-123,61,-70,43,121,10,21,-101,-97,94,-54,78,-44,-84,-27,-13,115,-89,87,-81,88,-88,80,-12,-22,-42,116,79,-82,-23,-43,-25,-26,-83,-24,44,-41,117,122,-21,22,11,-11,89,-53,95,-80,-100,-87,81,-96,127,12,-10,111,23,-60,73,-20,-40,67,31,45,-92,118,123,-73,-52,-69,62,90,-5,96,-79,-122,59,82,-95,108,-86,85,41,-99,-105,-78,-121,-112,97,-66,-36,-4,-68,-107,-49,-51,55,63,91,-47,83,57,-124,60,65,-94,109,71,20,42,-98,93,86,-14,-45,-85,68,17,-110,-39,35,32,46,-119,-76,124,-72,38,119,-103,-29,-91,103,74,-19,-34,-59,49,-2,24,13,99,-116,-128,-64,-9,112,7};
	public static final byte[] EXP = {1,3,5,15,17,51,85,-1,26,46,114,-106,-95,-8,19,53,95,-31,56,72,-40,115,-107,-92,-9,2,6,10,30,34,102,-86,-27,52,92,-28,55,89,-21,38,106,-66,-39,112,-112,-85,-26,49,83,-11,4,12,20,60,68,-52,79,-47,104,-72,-45,110,-78,-51,76,-44,103,-87,-32,59,77,-41,98,-90,-15,8,24,40,120,-120,-125,-98,-71,-48,107,-67,-36,127,-127,-104,-77,-50,73,-37,118,-102,-75,-60,87,-7,16,48,80,-16,11,29,39,105,-69,-42,97,-93,-2,25,43,125,-121,-110,-83,-20,47,113,-109,-82,-23,32,96,-96,-5,22,58,78,-46,109,-73,-62,93,-25,50,86,-6,21,63,65,-61,94,-30,61,71,-55,64,-64,91,-19,44,116,-100,-65,-38,117,-97,-70,-43,100,-84,-17,42,126,-126,-99,-68,-33,122,-114,-119,-128,-101,-74,-63,88,-24,35,101,-81,-22,37,111,-79,-56,67,-59,84,-4,31,33,99,-91,-12,7,9,27,45,119,-103,-80,-53,70,-54,69,-49,74,-34,121,-117,-122,-111,-88,-29,62,66,-58,81,-13,14,18,54,90,-18,41,123,-115,-116,-113,-118,-123,-108,-89,-14,13,23,57,75,-35,124,-124,-105,-94,-3,28,36,108,-76,-57,82,-10,1};
	
	public Tables() {}
	
	public byte FFMulFast(byte a, byte b){
		if (a == 0 || b == 0) return 0;
		int t = (LOG[(a & 0xff)] & 0xff) + (LOG[(b & 0xff)] & 0xff);
		return EXP[((t>255 ? t-255 : t) & 0xff)];
	}
	
	public byte FFInv(byte b) {
		return EXP[0xff - (LOG[b & 0xff] & 0xff)];
	}
}
