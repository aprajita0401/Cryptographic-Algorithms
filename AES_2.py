# Initial and Final Permutation tables 
IP_table = [ 
    58, 50, 42, 34, 26, 18, 10, 2, 
    60, 52, 44, 36, 28, 20, 12, 4, 
    62, 54, 46, 38, 30, 22, 14, 6, 
    64, 56, 48, 40, 32, 24, 16, 8, 
    57, 49, 41, 33, 25, 17, 9, 1, 
    59, 51, 43, 35, 27, 19, 11, 3, 
    61, 53, 45, 37, 29, 21, 13, 5, 
    63, 55, 47, 39, 31, 23, 15, 7 
] 
FP_table = [ 
    40, 8, 48, 16, 56, 24, 64, 32, 
    39, 7, 47, 15, 55, 23, 63, 31, 
    38, 6, 46, 14, 54, 22, 62, 30, 
    37, 5, 45, 13, 53, 21, 61, 29, 
    36, 4, 44, 12, 52, 20, 60, 28, 
    35, 3, 43, 11, 51, 19, 59, 27, 
    34, 2, 42, 10, 50, 18, 58, 26, 
33, 1, 41, 9, 49, 17, 57, 25 
] 
def hex_to_bin(hex_string): 
    binary = bin(int(hex_string, 16))[2:].zfill(64) 
    return binary 
def permute(input_bin, table): 
    return ''.join(input_bin[i - 1] for i in table) 
def bin_to_hex(binary_string): 
    hex_string = hex(int(binary_string, 2))[2:].zfill(16) 
    return hex_string.upper() 
# Given hexadecimal input 
hex_input = "0001002000000008" 
# Convert to binary 
binary_input = hex_to_bin(hex_input) 
# Apply Initial Permutation 
ip_result = permute(binary_input, IP_table) 
# Apply Final Permutation 
fp_result = permute(ip_result, FP_table) 
# Convert the final result to hexadecimal 
final_hex_output = bin_to_hex(fp_result) 
# Print results 
print("Input (Hex):", hex_input) 
print("Input (Binary)    :", binary_input) 
print("After IP (Binary) :", ip_result) 
print("After FP (Binary) :", fp_result) 
print("Final Output (Hex):", final_hex_output) 