function isFibonacci(n) {
    if (n == 1 || n == 2) {
        return 1;
    }
    return isFibonacci(n - 1) + isFibonacci(n - 2);
}
var sum = 0;
var number = 10;
for (var i = 1; i <= number; i++) {
    console.log(isFibonacci(i));
    sum += isFibonacci(i);
}
console.log("Tổng của fibonacci:"+ sum);
