package main;
/*
 * 버니버니 게임입니다.
 * 
 * 플레이어는 토끼를 잡아야 합니다.
 * 토끼는 무작위로 움직입니다.
 * 토끼를 잡지 않으면 두 마리로 분열합니다.
 * 토끼를 잡을 때마다 카운트가 하나씩 올라갑니다.
 * 
 * 가끔씩 랜덤한 모서리에서 사자가 나옵니다.
 * 플레이어가 사자한테 잡아먹히면 게임이 종료됩니다.
 * 필드에 토끼가 많을수록 사자가 빨리 나옵니다.
 * 사자가 토끼 위로 올라갈 경우 토끼는 사라집니다.
 * 
 * 
 * 필드는 10행 20열(x축이 열, y축이 행)이며 플레이어의 시작 위치는 (0,0)입니다.
 */
