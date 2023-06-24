type Fn = (...params: any) => any

function memoize(fn: Fn): Fn {
    const memo = {};

    return function(...args) {
        if (getHash(...args) in memo) {
            return memo[getHash(...args)];
        }

        return memo[getHash(...args)] = fn(...args);
    }
}

const getHash = (...args) => {
    let ret = `${args[0]}`;

    for (let i = 1; i < args.length; i++) {
        ret += `+${args[i]}`;
    }

    return ret;
}


/** 
 * let callCount = 0;
 * const memoizedFn = memoize(function (a, b) {
 *	 callCount += 1;
 *   return a + b;
 * })
 * memoizedFn(2, 3) // 5
 * memoizedFn(2, 3) // 5
 * console.log(callCount) // 1 
 */