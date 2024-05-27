import argparse
import os
import json
import openai

def ask_openai(prompt):
    response = openai.chat.completions.create(
        model="gpt-3.5-turbo",
        messages=[
            {"role": "system", "content": "You are a helpful assistant in computer science. When I gave you a list of files, you gave me feedback on them and rating from 0 to 10 for each of the SOLID principles"},
            {"role": "user", "content": prompt},
        ],
    )
    return response.choices[0].message.content

if __name__ == '__main__':
    parser = argparse.ArgumentParser(description='Process some files')
    parser.add_argument('file_list', type=str, help='File list')
    parser.add_argument('file_output', type=str, help='Output file')
    api_key = os.environ.get("OPENAI_API_KEY")
    openai.api_key = api_key
    if api_key is None:
        print("OPENAI_API_KEY environment variable must be set")
    args = parser.parse_args()
    print(args.file_list)

    file_list = []
    with open(args.file_list) as f:
        file_list = json.load(f)

    with open(args.file_output, 'w') as f:
        data = ""
        for file in file_list:
            data += file + "\n"
            with open (file, "r") as myfile:
                data +=myfile.read()
        result = ask_openai("What do you think of these files?\n" + data)
        f.write(f"{result}\n")