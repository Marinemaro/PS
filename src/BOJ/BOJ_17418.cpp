#include <stdio.h>
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