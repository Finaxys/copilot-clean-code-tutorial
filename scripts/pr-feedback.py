import argparse
import os

if __name__ == '__main__':
    parser = argparse.ArgumentParser(description='Process some files')
    parser.add_argument('file_list', type=str, help='File list')
    api_key = os.environ.get("OPENAI_API_KEY")
    if api_key is None:
        print("OPENAI_API_KEY environment variable must be set")
    args = parser.parse_args()
    print(args.file_list)

    with open(args.file_list) as f:
        for line in f:
            print(line)