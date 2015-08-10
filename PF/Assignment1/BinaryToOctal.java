public class BinaryToOctal
{

	public static int convertBinaryToOctal(int n) 
	{
		try {

			int lastDigit;
			int counter = -1;
			int octal = 0;
			int sumSlot = 0;
			int nCopy = n;
			int x;
			int innerCounter = 0;
			while (nCopy != 0 && innerCounter < 3) {

				lastDigit = nCopy % 10;

				if (lastDigit > 1) {

					throw new Exception();
				}

				if (innerCounter == 0) {
					x = 1;

				} else
					x = (2 << (innerCounter - 1));

				sumSlot = sumSlot + x * lastDigit;
				nCopy = nCopy / 10;
				innerCounter++;

				if (innerCounter == 3 || nCopy == 0) {
					counter++;
					octal = octal + sumSlot * (int) Math.pow(10, counter);
					innerCounter = 0;
					sumSlot = 0;
				}

			}

			return octal;

		} catch (Exception e) {
			// error
		}
	
	}

}
