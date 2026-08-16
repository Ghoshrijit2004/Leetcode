# 🧩 LeetCode Solutions

![Java](https://img.shields.io/badge/Language-Java-orange?style=flat-square&logo=java)
![Problems Solved](https://img.shields.io/badge/Problems%20Solved-7-brightgreen?style=flat-square)
![License](https://img.shields.io/badge/License-MIT-blue?style=flat-square)

A collection of my LeetCode problem-solving journey — clean, commented Java solutions with explanations and complexity analysis.

---

## 📑 Table of Contents

| # | Problem | Difficulty | Solution |
|---|---------|------------|----------|
| 1 | [Two Sum](#1-two-sum) | 🟢 Easy | [Jump](#1-two-sum) |
| 7 | [Reverse Integer](#7-reverse-integer) | 🟠 Medium | [Jump](#7-reverse-integer) |
| 9 | [Palindrome Number](#9-palindrome-number) | 🟢 Easy | [Jump](#9-palindrome-number) |
| 231 | [Power of Two](#231-power-of-two) | 🟢 Easy | [Jump](#231-power-of-two) |
| 326 | [Power of Three](#326-power-of-three) | 🟢 Easy | [Jump](#326-power-of-three) |
| 342 | [Power of Four](#342-power-of-four) | 🟢 Easy | [Jump](#342-power-of-four) |
| 509 | [Fibonacci Number](#509-fibonacci-number) | 🟢 Easy | [Jump](#509-fibonacci-number) |

---

## 1. Two Sum

**Problem:** Given an array of integers `nums` and an integer `target`, return the indices of the two numbers such that they add up to `target`.

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }
        return ans;
    }
}
```

**Approach**
- Brute force: check every pair `(i, j)` with `j > i` and see if they sum to `target`.
- Once a matching pair is found, store their indices.

**Complexity**
- ⏱ Time: `O(n²)` — nested loop over all pairs
- 💾 Space: `O(1)` (excluding the output array)

> 💡 **Optimization tip:** This can be improved to `O(n)` using a `HashMap` to store each number's complement as you iterate, avoiding the nested loop.

---

## 7. Reverse Integer

**Problem:** Given a signed 32-bit integer `x`, return `x` with its digits reversed. If reversing causes the value to go outside the signed 32-bit integer range `[-2^31, 2^31 - 1]`, return `0`.

```java
class Solution {
    public int reverse(int x) {
        int n = Math.abs(x);      // absolute value of x
        int revNum = 0;

        while (n > 0) {
            int d = n % 10;

            // check for overflow before it happens
            if (revNum > (Integer.MAX_VALUE - d) / 10) {
                return 0;
            }

            revNum = revNum * 10 + d;
            n = n / 10;
        }

        if (x < 0) {
            revNum = -revNum;
        }

        return revNum;
    }
}
```

**Approach**
- Work with the absolute value of `x` so digit extraction is straightforward.
- Peel off digits one at a time using `% 10` and `/ 10`, rebuilding the reversed number.
- Before appending a new digit, check whether doing so would overflow `Integer.MAX_VALUE` — if so, return `0` immediately.
- Restore the original sign at the end.

**Complexity**
- ⏱ Time: `O(log₁₀ x)` — one iteration per digit
- 💾 Space: `O(1)`

---

## 9. Palindrome Number

**Problem:** Given an integer `x`, return `true` if `x` is a palindrome, and `false` otherwise.

```java
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;          // negative numbers are never palindromes
        }

        int n = x;
        int revNum = 0;

        while (n > 0) {
            int d = n % 10;
            revNum = revNum * 10 + d;
            n = n / 10;
        }

        return revNum == x;
    }
}
```

**Approach**
- Negative numbers can't be palindromes (the `-` sign breaks symmetry), so return `false` immediately.
- Reverse the digits of `x` the same way as in Reverse Integer.
- Compare the reversed number with the original — if they match, it's a palindrome.

**Complexity**
- ⏱ Time: `O(log₁₀ x)`
- 💾 Space: `O(1)`

---

## 231. Power of Two

**Problem:** Given an integer `n`, return `true` if it is a power of two, and `false` otherwise.

```java
class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n < 1) {
            return false;
        } else if (n == 1) {
            return true;
        } else {
            while (n % 2 == 0) {
                n = n / 2;
            }
            return n == 1;
        }
    }
}
```

**Approach**
- Powers of two must be positive, so any `n < 1` is immediately `false`.
- Repeatedly divide `n` by `2` as long as it's evenly divisible.
- If what remains is exactly `1`, the original number was a pure power of two.

**Complexity**
- ⏱ Time: `O(log₂ n)`
- 💾 Space: `O(1)`

> 💡 **Optimization tip:** A power of two has exactly one bit set, so `(n & (n - 1)) == 0` (for `n > 0`) solves this in `O(1)`.

---

## 326. Power of Three

**Problem:** Given an integer `n`, return `true` if it is a power of three, and `false` otherwise.

```java
class Solution {
    public boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        } else if (n == 1) {
            return true;
        } else {
            while (n % 3 == 0) {
                n = n / 3;
            }
            return n == 1;
        }
    }
}
```

**Approach**
- Same divide-and-check pattern as Power of Two, but dividing by `3` instead.
- Keep dividing while evenly divisible; if `1` remains, `n` was a power of three.

**Complexity**
- ⏱ Time: `O(log₃ n)`
- 💾 Space: `O(1)`

---

## 342. Power of Four

**Problem:** Given an integer `n`, return `true` if it is a power of four, and `false` otherwise.

```java
class Solution {
    public boolean isPowerOfFour(int n) {
        if (n < 1) {
            return false;
        } else if (n == 1) {
            return true;
        } else {
            while (n % 4 == 0) {
                n = n / 4;
            }
            return n == 1;
        }
    }
}
```

**Approach**
- Same pattern again, dividing by `4` this time.
- Keep dividing while evenly divisible; if `1` remains, `n` was a power of four.

**Complexity**
- ⏱ Time: `O(log₄ n)`
- 💾 Space: `O(1)`

---

## 509. Fibonacci Number

**Problem:** The Fibonacci numbers form a sequence where each number is the sum of the two preceding ones, starting from `0` and `1`. Given `n`, calculate `F(n)`.

```java
class Solution {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        int firstTerm = 0;
        int secondTerm = 1;

        for (int i = 1; i <= n; i++) {
            int thirdTerm = firstTerm + secondTerm;
            firstTerm = secondTerm;
            secondTerm = thirdTerm;
        }

        return firstTerm;
    }
}
```

**Approach**
- Handle the base cases `F(0) = 0` and `F(1) = 1` directly.
- Iteratively build up the sequence, tracking only the last two terms instead of using recursion or extra memory for the whole sequence.

**Complexity**
- ⏱ Time: `O(n)`
- 💾 Space: `O(1)`

---

## 🚀 About

This repo tracks my progress solving LeetCode problems, mainly in Java, with a focus on writing clean, efficient, and well-explained solutions.

⭐ Feel free to star the repo if you find it useful, and PRs/suggestions are welcome!

<!---LeetCode Topics Start-->
# LeetCode Topics
## Math
| Problem Name | Difficulty |
| ------- | ------- |
| [0342-power-of-four](https://github.com/Ghoshrijit2004/Leetcode/tree/main/0342-power-of-four/) | Easy |
## Bit Manipulation
| Problem Name | Difficulty |
| ------- | ------- |
| [0342-power-of-four](https://github.com/Ghoshrijit2004/Leetcode/tree/main/0342-power-of-four/) | Easy |
## Recursion
| Problem Name | Difficulty |
| ------- | ------- |
| [0342-power-of-four](https://github.com/Ghoshrijit2004/Leetcode/tree/main/0342-power-of-four/) | Easy |
<!---LeetCode Topics End-->