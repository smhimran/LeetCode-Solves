func myPow(x float64, n int) float64 {
    if n == 0 {
        return 1.0
    }

    powOfNByTwo := myPow(x, n / 2)
    
    if isOdd(n) {
        if n < 0 {
            return (powOfNByTwo * powOfNByTwo) / x
        }
        
        return powOfNByTwo * powOfNByTwo * x
    }

    return powOfNByTwo * powOfNByTwo
}

func isOdd(n int) bool {
    return n % 2 != 0;
}