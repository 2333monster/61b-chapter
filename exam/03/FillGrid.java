public class FillGrid{
	public static void fillgrid(int[] LL, int[] UR, int[][] S){
		int N = S.length;
		int kL, kR;
		kL = kR = 0;

		for(int i = 0; i < N; i += 1){
			for(int j = 0; j < N; j += 1){
				if(i == j){
					S[i][j] = 0;
				}
				if(i > j){
					S[i][j] = LL[kL];
					kL += 1;
				}
				if(i < j){
					S[i][j] = UR[kR];
					kR += 1;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] LL = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0 };
		int[] UR = { 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
		int[][] S = {
		{ 0, 0, 0, 0, 0},
		{ 0, 0, 0, 0, 0},
		{ 0, 0, 0, 0, 0},
		{ 0, 0, 0, 0, 0},
		{ 0, 0, 0, 0, 0}
		};

		fillgrid(LL,UR,S);
		for(int i = 0; i < S.length; i += 1){
			for(int j = 0; j < S.length; j += 1){
				if(j == S.length - 1){
					System.out.println(S[i][j]);
					continue;
				}
				System.out.print(S[i][j] + " ");
			}
		}
	}
}