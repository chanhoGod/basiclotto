import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class LottoPro {
	Scanner s = new Scanner(System.in);
	LottoResource lR = new LottoResource();
	Random randN = new Random();

	public void start() {
		System.out.println("�ζ� ���α׷��� �����մϴ�.");
		System.out.println("�ε���");
		try {
			for (int i = 1; i <= 5; i++) {
				Thread.sleep(100);
				System.out.println((20 * i) + "%");
				if (i == 5) {
					System.out.println("ȯ���մϴ�.");
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		do {
			System.out.println("---------Menu---------");
			System.out.println("1.��÷    2.��÷ ����    3.������");
			System.out.println("----------------------");
			System.out.print(">>");
			int n = s.nextInt();

			switch (n) {
			case 1:
				draw();
				break;
			case 2:
				win();
				break;
			case 3:
				System.out.println("�����մϴ�.");
				s.close();
				return;
			}
		} while (true);
	}

	public void draw() {
		System.out.println("�ּ� õ���� ������� �̿밡���ϸ� �ִ� �ټ������ ������ �� �ֽ��ϴ�.");
		lR.setMoney(s.nextInt());
		if (1 <= lR.getMoney() / 1000 && lR.getMoney() / 1000 <= 5 && lR.getMoney() % 1000 == 0) {
			lR.setBalance(lR.getMoney());
		} else {
			System.err.print("�����Դϴ�!! ���α׷��� �ٽ� ������� �ֽñ� �ٶ��ϴ�.");
			s.close();
		}
		int chance = lR.getBalance() / 1000;
		int[][] lottoNumber = new int[chance][6];

		for (int i = 0; i < chance; i++) {
			for (int j = 0; j < 6; j++) {
				lottoNumber[i][j] = randN.nextInt(46) + 1;
				for (int k = 0; k < j; k++) {
					if (lottoNumber[i][j] == lottoNumber[i][k]) {
						j--;
					}
				}
			}
		}
		// ����
		lottoSort(lottoNumber);
		// ���
		for (int i = 0; i < lottoNumber.length; i++) {
			System.out.print("��ȣ : ");
			for (int j = 0; j < lottoNumber[0].length; j++) {
				System.out.print(lottoNumber[i][j] + " ");
			}
			System.out.println();
		}
		lR.setMyNumber(lottoNumber);
	}

	private void win() {
		int[][] winNumber = new int[1][6];
		for (int i = 0; i < 6; i++) {
			winNumber[0][i] = randN.nextInt(46) + 1;
		}

		lottoSort(winNumber);

		// ���
		System.out.print("�̹��� ��÷��ȣ : ");
		for (int i = 0; i < 6; i++) {
			System.out.print(winNumber[0][i] + " ");
		}
		System.out.println();

		int winCount = 0;
		for (int i = 0; i < lR.getMyNumber().length; i++) {
			for (int j = 0; j < winNumber.length; j++) {
				if (winNumber[0][j] == lR.getMyNumber()[i][j]) {
					winCount++;
				}
			}
		}
		switch (winCount) {
		case 0:
			System.out.println("��÷���� 0��. ������ȸ�� ���������.");
			break;
		case 1:
			System.out.println("��÷���� 1��. ������ȸ�� ���������.");
			break;
		case 2:
			System.out.println("��÷���� 2��. ������ȸ�� ���������.");
			break;
		case 3:
			System.out.println("��! ��÷�Ǿ����ϴ�. ��÷���� 3��!!");
			break;
		case 4:
			System.out.println("��! ��÷�Ǿ����ϴ�. ��÷���� 4��!!");
			break;
		case 5:
			System.out.println("��! ��÷�Ǿ����ϴ�. ��÷���� 5��!!");
			break;
		case 6:
			System.out.println("��! ��÷�Ǿ����ϴ�. ��÷���� 6��!!");
			System.out.println("1���Դϴ�!!");
		}
	}

	// ���� �޼ҵ�
	public void lottoSort(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			Arrays.sort(array[i]);
		}
	}
}
