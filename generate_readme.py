import os
import re

# Categorization based on ranges (e.g., 0001-1000, 1001-2000)
def get_folder_name(number):
    start = ((number - 1) // 1000) * 1000 + 1
    end = start + 999
    return f"{start:04d}-{end:04d}"

README_FILE = "README.md"
BASE_URL = "https://leetcode.com/problems/"

def get_problem_link(title_slug):
    # Converts 'rotate_box' to 'rotate-box'
    return BASE_URL + title_slug.replace('_', '-').strip('-') + "/"

def parse_filename(filename):
    # Pattern: {ProblemNumber}_{title}.ext or {ProblemNumber} _{title}.ext
    match = re.search(r"^(\d+)\s*[_ ]+([\w\d_ ]+)\.(\w+)$", filename)
    if match:
        number = int(match.group(1))
        title_slug = match.group(2).strip().replace(' ', '_').lower()
        title = title_slug.replace('_', ' ').title()
        return number, title, title_slug
    return None

def organize_files():
    # Move files into respective range folders if they are in the root
    for filename in os.listdir('.'):
        if os.path.isfile(filename) and filename not in ['generate_readme.py', README_FILE] and not filename.startswith('.'):
            parsed = parse_filename(filename)
            if parsed:
                num, title, slug = parsed
                folder = get_folder_name(num)
                if not os.path.exists(folder):
                    os.makedirs(folder)
                new_path = os.path.join(folder, filename)
                print(f"Moving {filename} to {new_path}")
                os.rename(filename, new_path)

def generate_readme():
    content = "# LeetCode Solutions\n\n"
    content += "My personal LeetCode progress tracker. Solutions are automatically organized into folders by ranges.\n\n"
    content += "[![LeetCode Profile](https://img.shields.io/badge/LeetCode-Profile-orange?style=for-the-badge&logo=leetcode)](https://leetcode.com/u/seronsenapati/)\n\n"
    
    # Collect all folders
    folders = sorted([f for f in os.listdir('.') if os.path.isdir(f) and re.match(r'^\d+-\d+$', f)])

    total_solved = 0
    for folder in folders:
        files = os.listdir(folder)
        for f in files:
            if parse_filename(f):
                total_solved += 1

    content += "## Stats\n"
    content += f"- Total Questions Solved: **{total_solved}**\n\n"
    
    # Quick Links
    if folders:
        content += "## Quick Navigation\n"
        for folder in folders:
            content += f"- [{folder}](#{folder})\n"
        content += "\n---\n"

    for folder in folders:
        content += f"## {folder}\n\n"
        content += "| Problem Number | Title | Solution | LeetCode Link |\n"
        content += "|---|-------|----------|---------------|\n"
        
        # Sort files by problem number
        files = os.listdir(folder)
        parsed_files = []
        for f in files:
            p = parse_filename(f)
            if p:
                parsed_files.append((p[0], p[1], p[2], f))
        
        parsed_files.sort(key=lambda x: x[0])

        for num, title, slug, filename in parsed_files:
            sol_link = f"[{filename.split('.')[-1].upper()}]({folder}/{filename.replace(' ', '%20')})"
            problem_link = f"[Problem]({get_problem_link(slug)})"
            content += f"| {num} | {title} | {sol_link} | {problem_link} |\n"
        content += "\n"

    with open(README_FILE, "w") as f:
        f.write(content)

if __name__ == "__main__":
    organize_files()
    generate_readme()
