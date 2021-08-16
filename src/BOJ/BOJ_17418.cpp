#include <stdio.h>

/*
문제 해결 아이디어
1. 기본 명령어(INPUT, NOT , BNOT, AND, AR, XOR, LSHIFT, RSHIFT)에 대해 함수화한다.
2. 아래와 조합함수를 선언한다.
RESET() : 현재 메모리값과 0을 저장하고 있는 100번 메모리를 AND 연산 = 현재 메모리를 0으로 초기화
MOV() : 현재 메모리값을 BNOT 연산한 값을 임시 메모리 99번 메모리에 저장
        99번 메모리에 저장된 값을 BNOT 연산하여 목표 메모리에 저장 = A메모리값을 B메모리로 이동
ADD() : 비트연산을 통해 가산 구현
NEGATE() : 2의 보수법을 사용하므로 원래 수를 비트반전한 후 1을 더해줌으로써 부호를 바꾼다.
SUB() : a-b = a+(-b) 이므로 NEGATE()와 ADD()를 통해 감산 구현
MSBCHECK() : 16번째 비트를 부호비트로 정했으므로, RSHIFT(15)한 후 1과 AND 하여 부호비트를 검사한다.
3. H값과 W값은 stdin으로 입력되기 때문에 G++ 에서 입력받을 이유가 없으므로 입력을 버린다.
4. 1~16번 메모리에는 각각 1~16까지의 상수가 저장된다.
5. 21~36번 메모리에는 H*W개의 원소들이 저장된다.
6. 41~56번 메모리에는 H*W개의 원소들의 마스크가 저장된다.
7. 91~94번 메모리에는 a,b,c,d 값이 저장된다.
8. 부호비트 체크 결과가 저장되는 17번 메모리와 0xFFFFFFFF가 저장된 19번 메모리를 더하는데,
   만약 부호비트 체크 결과가 1(false)이라면 오버플로우가 발생해 0x00000000이 되고,
   0(true)라면 0xFFFFFFFF가 유지되므로 이를 마스크에 활용할 수 있게 된다.
9. 위에서 구한 마스크값과 H*W개만큼의 원소들을 AND 연산한값을 0번 메모리에 ADD 한 후 나머지 메모리를 RESET() 하면 정답이다.
*/

void INPUT(int m) {printf("INPUT %d\n",m);}
void NOT(int m, int o) {printf("NOT %d %d\n",m,o);}
void BNOT(int m, int o) {printf("BNOT %d %d\n",m,o);}
void AND(int m, int n, int o) {printf("AND 2 %d %d %d\n",m,n,o);}
void OR(int m, int n, int o) {printf("OR 2 %d %d %d\n",m,n,o);}
void XOR(int m, int n, int o) {printf("XOR 2 %d %d %d\n",m,n,o);}
void LSHIFT(int m, int n, int o) {printf("LSHIFT %d %d %d\n",m,n,o);}
void RSHIFT(int m, int n, int o) {printf("RSHIFT %d %d %d\n",m,n,o);}
void RESET(int m) {AND(m, 100, m);}
void MOV(int m, int o) {
	BNOT(m, 99);
	BNOT(99, o);
}
void ADD(int m, int n, int o) {
	MOV(m, 71);
	MOV(n, 72);
	
	int k;
	for(k=0; k<16; k++) {	// MSB : 16th bit
		XOR(71, 72, 74+k);
		AND(71, 72, 73);
		LSHIFT(73, 1, 73);
		MOV(74+k, 71);
		MOV(73, 72);
	}MOV(89, o);
}
void NEGATE() {
	BNOT(90, 90);
	ADD(90, 1, 90);
}
void SUB(int m, int n, int o) {
	MOV(n, 90);
	NEGATE();
	ADD(m, 90, o);
}
void MSBCHECK() {
	RSHIFT(18, 15, 18);
	AND(18, 1, 18);
	OR(17, 18, 17);
}
int main() {
	int H, W, i, j;
	scanf("%d %d",&H,&W);
	
	INPUT(99);
	INPUT(99);
	for(i=1; i<=H*W; i++) INPUT(i+20);
	for(i=1; i<=4; i++) INPUT(i+90);
	
	NOT(1, 1);
	for(i=1; i<16; i++) ADD(i, 1, i+1);
	for(i=0; i<H; i++) {
		for(j=0; j<W; j++) {
			RESET(17);
			RESET(19);
			
			MOV(j, 18);
			SUB(18, 92, 18);
			MSBCHECK();
			MOV(j, 18);
			SUB(94, 18, 18);
			MSBCHECK();
			MOV(i, 18);
			SUB(18, 91, 18);
			MSBCHECK();
			MOV(i, 18);
			SUB(93, 18, 18);
			MSBCHECK();
			
			BNOT(19, 19);
			ADD(19, 17, 19);
			MOV(19, 41+i*W+j);
		}
	}
	for(i=1; i<=H*W; i++) {	
		AND(i+20, i+40, i+20);
		ADD(0, i+20, 0);
	}
	for(i=1; i<=99; i++) RESET(i);
}