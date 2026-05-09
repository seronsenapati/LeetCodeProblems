# LeetCode Solutions

My personal LeetCode progress tracker. Solutions are automatically organized into folders by ranges.

[![LeetCode Profile](https://img.shields.io/badge/LeetCode-Profile-orange?style=for-the-badge&logo=leetcode)](https://leetcode.com/u/seronsenapati/)

## Stats
- Total Questions Solved: **17**

## 🔍 Search Problems

<div style="margin: 20px 0;">
  <input type="text" id="searchBox" placeholder="Search by problem number (e.g., 1, 53, 1752)..." style="width: 100%; padding: 10px; font-size: 16px; border: 2px solid #0366d6; border-radius: 5px;">
  <p id="searchResult" style="margin-top: 10px; color: #666;"></p>
</div>

<script>
document.getElementById('searchBox').addEventListener('input', function() {
  const searchTerm = this.value.trim();
  const tables = document.querySelectorAll('table');
  const sections = document.querySelectorAll('h2');
  let found = 0;
  
  if (searchTerm === '') {
    tables.forEach(table => table.style.display = '');
    sections.forEach(section => {
      if (section.textContent.includes('0001-1000') || 
          section.textContent.includes('1001-2000') || 
          section.textContent.includes('3001-4000')) {
        section.style.display = '';
      }
    });
    document.getElementById('searchResult').textContent = '';
    return;
  }
  
  tables.forEach((table, idx) => {
    const rows = table.querySelectorAll('tbody tr');
    let hasMatch = false;
    rows.forEach(row => {
      const problemNum = row.cells[0].textContent.trim();
      if (problemNum.includes(searchTerm)) {
        row.style.display = '';
        hasMatch = true;
        found++;
      } else {
        row.style.display = 'none';
      }
    });
    table.style.display = hasMatch ? '' : 'none';
    
    if (hasMatch) {
      sections[idx + 2].style.display = '';
    } else {
      sections[idx + 2].style.display = 'none';
    }
  });
  
  document.getElementById('searchResult').textContent = 
    searchTerm ? `Found ${found} problem${found !== 1 ? 's' : ''}` : '';
});
</script>

## Quick Navigation
- [0001-1000](#0001-1000)
- [1001-2000](#1001-2000)
- [3001-4000](#3001-4000)

---
## 0001-1000

| Problem Number | Title | Solution | LeetCode Link |
|---|-------|----------|---------------|
| 1 | Two Sum | [JAVA](0001-1000/1_two_sum.java) | [Problem](https://leetcode.com/problems/two-sum/) |
| 7 | Reverse Integer | [JAVA](0001-1000/7_reverse_integer.java) | [Problem](https://leetcode.com/problems/reverse-integer/) |
| 26 | Remove Duplicates From Sorted Array | [JAVA](0001-1000/26_remove_duplicates_from_sorted_array.java) | [Problem](https://leetcode.com/problems/remove-duplicates-from-sorted-array/) |
| 48 | Rotate Image | [JAVA](0001-1000/48_rotate_image.java) | [Problem](https://leetcode.com/problems/rotate-image/) |
| 53 | Maximum Subarray (Kadane's Algorithm) | [JAVA](0001-1000/53_maximum_subarray.java) | [Problem](https://leetcode.com/problems/maximum-subarray/) |
| 61 | Rotate List | [JAVA](0001-1000/61_rotate_list.java) | [Problem](https://leetcode.com/problems/rotate-list/) |
| 136 | Single Number | [JAVA](0001-1000/136_single_number.java) | [Problem](https://leetcode.com/problems/single-number/) |
| 169 | Majority Element | [JAVA](0001-1000/169_majority_element.java) | [Problem](https://leetcode.com/problems/majority-element/) |
| 189 | Rotate Array | [JAVA](0001-1000/189_rotate_array.java) | [Problem](https://leetcode.com/problems/rotate-array/) |
| 283 | Move Zeroes | [JAVA](0001-1000/283_move_zeroes.java) | [Problem](https://leetcode.com/problems/move-zeroes/) |
| 485 | Max Consecutive Ones | [JAVA](0001-1000/485_max_consecutive_ones.java) | [Problem](https://leetcode.com/problems/max-consecutive-ones/) |
| 796 | Rotate String | [JAVA](0001-1000/796_Rotate_String.java) | [Problem](https://leetcode.com/problems/rotate-string/) |

## 1001-2000

| Problem Number | Title | Solution | LeetCode Link |
|---|-------|----------|---------------|
| 1752 | Check If Array Is Sorted And Rotated | [JAVA](1001-2000/1752_check_if_array_is_sorted_and_rotated.java) | [Problem](https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/) |
| 1861 | Rotating The Box | [JAVA](1001-2000/1861_rotating_the_box.java) | [Problem](https://leetcode.com/problems/rotating-the-box/) |
| 1914 | Cyclically Rotating A Grid | [JAVA](1001-2000/1914_cyclically_rotating_a_grid.java) | [Problem](https://leetcode.com/problems/cyclically-rotating-a-grid/) |

## 3001-4000

| Problem Number | Title | Solution | LeetCode Link |
|---|-------|----------|---------------|
| 3629 | Minimum Jumps To Reach End Via Prime Teleportation | [JAVA](3001-4000/3629_minimum_jumps_to_reach_end_via_prime_teleportation.java) | [Problem](https://leetcode.com/problems/minimum-jumps-to-reach-end-via-prime-teleportation/) |
| 3660 | Jump Game Ix | [JAVA](3001-4000/3660_jump_game_ix.java) | [Problem](https://leetcode.com/problems/jump-game-ix/) |

