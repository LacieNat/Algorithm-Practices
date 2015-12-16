
public class ImageRotate {
	public static void main(String args[]) {
		int[][] sample = {
			{1,2,3, 11, 12, 13},
			{4,5,6, 24, 25, 26},
			{7,8,9, 37, 38, 39},
			{41, 42, 43, 44, 45, 46},
			{51, 52, 53, 54, 55, 56},
			{61, 62, 63, 64, 65, 66}
		};
		
		sample = rotateImage(sample);
		
		for(int i=0; i<sample.length; i++) {
			for(int j=0; j<sample.length; j++) {
				System.out.print(sample[i][j] + " ");
			}
			
			System.out.println();
		}
	}
	
	
	//O(n^2) :(
	public static int[][] rotateImage(int[][] image) {
		int n = image.length;
		int[][] rotatedImage = new int[n][n];
		
		for(int i=0; i<n; i++) {
			
			for(int j=0; j<n; j++) {
				rotatedImage[j][ (n-1) - i] = image[i][j];
			}
		}
		
		return rotatedImage;
	}
}


