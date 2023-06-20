function map(arr: number[], fn: (n: number, i: number) => number): number[] {
    return arr.map((e: number, index: number) => fn(e, index));
};