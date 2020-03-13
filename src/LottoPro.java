import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class LottoPro {
	Scanner s = new Scanner(System.in);
	LottoResource lR = new LottoResource();
	Random randN = new Random();

	public void start() {
		System.out.println("로또 프로그램을 시작합니다.");
		System.out.println("로딩중");
		try {
			for (int i = 1; i <= 5; i++) {
				Thread.sleep(100);
				System.out.println((20 * i) + "%");
				if (i == 5) {
					System.out.println("환영합니다.");
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		do {
			System.out.println("---------Menu---------");
			System.out.println("1.추첨    2.당첨 여부    3.끝내기");
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
				System.out.println("종료합니다.");
				s.close();
				return;
			}
		} while (true);
	}

	public void draw() {
		System.out.println("최소 천원에 한장부터 이용가능하며 최대 다섯장까지 뽑으실 수 있습니다.");
		lR.setMoney(s.nextInt());
		if (1 <= lR.getMoney() / 1000 && lR.getMoney() / 1000 <= 5 && lR.getMoney() % 1000 == 0) {
			lR.setBalance(lR.getMoney());
		} else {
			System.err.print("오류입니다!! 프로그램을 다시 실행시켜 주시기 바랍니다.");
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
		// 정렬
		lottoSort(lottoNumber);
		// 출력
		for (int i = 0; i < lottoNumber.length; i++) {
			System.out.print("번호 : ");
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

		// 출력
		System.out.print("이번주 당첨번호 : ");
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
			System.out.println("당첨숫자 0개. 다음기회를 노려보세요.");
			break;
		case 1:
			System.out.println("당첨숫자 1개. 다음기회를 노려보세요.");
			break;
		case 2:
			System.out.println("당첨숫자 2개. 다음기회를 노려보세요.");
			break;
		case 3:
			System.out.println("축! 당첨되었습니다. 당첨숫자 3개!!");
			break;
		case 4:
			System.out.println("축! 당첨되었습니다. 당첨숫자 4개!!");
			break;
		case 5:
			System.out.println("축! 당첨되었습니다. 당첨숫자 5개!!");
			break;
		case 6:
			System.out.println("축! 당첨되었습니다. 당첨숫자 6개!!");
			System.out.println("1등입니다!!");
		}
	}

	// 정렬 메소드
	public void lottoSort(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			Arrays.sort(array[i]);
		}
	}
}
