type F = (x: number) => number;

function compose(functions: F[]): F {
	return function(x) {
        functions.reverse();
        return functions.reduce((result, fn) => {
            return fn(result);
        }, x);
    }
};

/**
 * const fn = compose([x => x + 1, x => 2 * x])
 * fn(4) // 9
 */