# 🧩 LeetCode Solutions

![Java](https://img.shields.io/badge/Language-Java-orange?style=flat-square&logo=java)
![Problems Solved](https://img.shields.io/badge/Problems%20Solved-2-brightgreen?style=flat-square)
![License](https://img.shields.io/badge/License-MIT-blue?style=flat-square)

A collection of my LeetCode problem-solving journey — clean, commented Java solutions with explanations and complexity analysis.

---

## 📑 Table of Contents

| # | Problem | Difficulty | Solution |
|---|---------|------------|----------|
| 7 | [Reverse Integer](#7-reverse-integer) | 🟠 Medium | [Jump](#7-reverse-integer) |
| 9 | [Palindrome Number](#9-palindrome-number) | 🟢 Easy | [Jump](#9-palindrome-number) |

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

## 🚀 About

This repo tracks my progress solving LeetCode problems, mainly in Java, with a focus on writing clean, efficient, and well-explained solutions.

⭐ Feel free to star the repo if you find it useful, and PRs/suggestions are welcome!
