function isFibonacci(n: number):any {
    if (n==1|| n==2){
        return 1;
    }
    return isFibonacci(n-1) + isFibonacci(n-2);
}

let sum = 0;
let number = 10;

for (let i = 1; i <= number; i++){
    console.log(isFibonacci(i));
    sum+=isFibonacci(i);
}

console.log("Tổng của fibonacci:"+ sum);
